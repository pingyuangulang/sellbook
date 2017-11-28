package com.hzit.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hzit.dao.interfaces.ISellOrderDao;
import com.hzit.entity.Book;
import com.hzit.entity.Customer;
import com.hzit.entity.SellOrder;
import com.hzit.entity.UnionOrderAndBook;
import com.hzit.util.dbutil.JDBCObject;
import com.hzit.util.dbutil.JDBCUtil;
import com.hzit.util.pageutil.PageBean;

public class SellOrderDaoImpl implements ISellOrderDao {
	//注入数据库操作工具类
	JDBCUtil jdbcutil = new JDBCUtil();
	@Override
	public boolean addBookToShopCar(SellOrder sellorder) {//添加到购物车
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into sell_order values(null,?,?,?,?,0)";
		Object[] params = {sellorder.getBook().getId(),sellorder.getCustomer().getId(),
				sellorder.getCount(),sellorder.getAmount()};
		int num = jdbcutil.exeUpdate(sql, params);
		if(num>0)
			flag = true;
		return flag;
	}
	//依据用户c_id查询订单，并分页
	@Override
	public PageBean<UnionOrderAndBook> getSellOrderByCustomerId(int c_id,PageBean<UnionOrderAndBook> pageBean) {
		// TODO Auto-generated method stub
		UnionOrderAndBook unionorderbook = null;
		List<UnionOrderAndBook> list = new ArrayList<UnionOrderAndBook>();
		String sql = "select so.id,so.count,so.amount,so.ispay,so.b_id,b.b_name,b.out_price,b.url from sell_order so,book b where so.b_id=b.id and so.c_id=? order by so.id desc limit ?,?";
		Object[] params = {c_id,(pageBean.getCurPage()-1)*pageBean.getPageSize(),pageBean.getPageSize()};
		JDBCObject jdbc = jdbcutil.exeQuery(sql, params);
		if(jdbc!=null){
			ResultSet res = jdbc.getRes();
			if(res!=null){
				try {
					while(res.next()){
						unionorderbook = new UnionOrderAndBook(res.getInt(1), res.getInt(2),
								res.getFloat(3), res.getInt(4), res.getInt(5), res.getString(6),
								res.getFloat(7), res.getString(8));
						list.add(unionorderbook);
					}
					pageBean.setData(list);
					String sqlcount = "select count(id) from sell_order where c_id=?";
					int totalRecord = jdbcutil.getCount(sqlcount, c_id);
					pageBean.setTotalRecord(totalRecord);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					jdbcutil.closeAll(jdbc);
				}
				return pageBean;
			}else
				return null;
		}else
			return null;
	}
	@Override
	public boolean delSellOrderById(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from sell_order where id=?";
		Object[] params = {id};
		int num = jdbcutil.exeUpdate(sql, params);
		if(num>0)
			flag = true;
		return flag;
	}
	
	
	//购买书籍，将订单表中的ispay改为1，书籍表中修改库存=原库存-购买数量,将订单信息加入admin_order表中
	@Override
	public boolean byBook(int sellorderid) {//数据库操作类中没有封装多表修改的方法，因此在此方法中直接操作数据库
		// TODO Auto-generated method stub
		SellOrder sellorder = getSellOrderById(sellorderid);
		boolean flag = false;
		Connection con = null;
		PreparedStatement pstorder = null;
		PreparedStatement pstbook = null;
		PreparedStatement pstadmorder = null;
		String udpOrder = "update sell_order set ispay=1 where id=?";//将order表中的未付款标致修改为已付款
		String udpBook = "update book set quantity=quantity-? where id=?";//修改book表中的库存数
		String insert_admin_order = "insert into admin_order values(null,?,?,?,?,?,?,?,0)";//向admin_order表中插入一条记录
		con = jdbcutil.getConnection();
		try{
			con.setAutoCommit(false);
			pstorder = con.prepareStatement(udpOrder);
			pstorder.setInt(1, sellorder.getId());
			
			pstbook = con.prepareStatement(udpBook);
			pstbook.setInt(1, sellorder.getCount());
			pstbook.setInt(2, sellorder.getBook().getId());
			
			pstadmorder = con.prepareStatement(insert_admin_order);
			pstadmorder.setInt(1, sellorder.getCount());
			pstadmorder.setFloat(2, sellorder.getAmount());
			pstadmorder.setString(3, sellorder.getBook().getB_name());
			pstadmorder.setString(4, sellorder.getBook().getUrl());
			pstadmorder.setString(5, sellorder.getCustomer().getC_name());
			pstadmorder.setString(6, sellorder.getCustomer().getPhone());
			pstadmorder.setString(7, sellorder.getCustomer().getAddress());
			
			int numorder = pstorder.executeUpdate();
			int numbook = pstbook.executeUpdate();
			int numadminorder = pstadmorder.executeUpdate();
			con.commit();
			if(numorder>0 && numbook>0 && numadminorder>0)
				flag = true;
		} catch (NullPointerException e){
			flag = false;
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			if(pstorder!=null)
				try {
					pstorder.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstbook!=null)
				try {
					pstbook.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstadmorder!=null)
				try {
					pstadmorder.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return flag;
	}
	@Override
	public SellOrder getSellOrderById(int id) {
		// TODO Auto-generated method stub
		SellOrder sellorder = null;
		String sql = "select * from sell_order o,book b,customer c where o.b_id=b.id and o.c_id=c.id and o.id=?";
		Object[] params = {id};
		JDBCObject jdbc = jdbcutil.exeQuery(sql, params);
		ResultSet res = jdbc.getRes();
		try {
			if(res.next())
				sellorder = new SellOrder(res.getInt(1), new Book(res.getInt(2),res.getString(8),res.getInt(9),
						res.getFloat(10),res.getFloat(11),res.getString(12),res.getString(13)), 
						new Customer(res.getInt(3), res.getString(15), res.getString(16), res.getString(17), res.getString(18)),
						res.getInt(4), res.getInt(6));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcutil.closeAll(jdbc);
		}
		return sellorder;
	}

}
