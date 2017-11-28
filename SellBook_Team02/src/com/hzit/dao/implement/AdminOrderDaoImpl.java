package com.hzit.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hzit.dao.interfaces.IAdminOrderDao;
import com.hzit.entity.AdminOrder;
import com.hzit.util.dbutil.JDBCObject;
import com.hzit.util.dbutil.JDBCUtil;
import com.hzit.util.pageutil.PageBean;

public class AdminOrderDaoImpl implements IAdminOrderDao {
	//注入数据库工具类
	JDBCUtil jdbcutil = new JDBCUtil();
	//获取分页AdminOrderPageBean
	@Override
	public PageBean<AdminOrder> getAdminOrder(int isdeal,PageBean<AdminOrder> adminorder_pageBean) {
		// TODO Auto-generated method stub
		
		String sql = null;
		String sqlcount = null;
		Object[] params = null;
		List<AdminOrder> list = new ArrayList<AdminOrder>();
		if(isdeal==1 || isdeal==0){
			sql = "select * from admin_order where isdeal=? order by id desc limit ?,?";
			params = new Object[3];
			params[0] = isdeal;
			params[1] = (adminorder_pageBean.getCurPage()-1)*adminorder_pageBean.getPageSize();
			params[2] = adminorder_pageBean.getPageSize();
			if(isdeal==1)
				sqlcount = "select count(id) from admin_order where isdeal=1";
			if(isdeal==0)
				sqlcount = "select count(id) from admin_order where isdeal=0";
		}
		else{
			sql = "select * from admin_order order by id desc limit ?,?";
			sqlcount = "select count(id) from admin_order";
			params = new Object[2];
			params[0] = (adminorder_pageBean.getCurPage()-1)*adminorder_pageBean.getPageSize();
			params[1] = adminorder_pageBean.getPageSize();
		}
		JDBCObject jdbc = jdbcutil.exeQuery(sql, params);
		if(jdbc!=null){
			ResultSet res = jdbc.getRes();
			AdminOrder adminorder = null;
			try {
				while(res.next()){
					adminorder = new AdminOrder(res.getInt("id"), res.getInt("count"), 
							res.getFloat("amount"), res.getString("b_name"), 
							res.getString("b_url"), res.getString("c_name"), 
							res.getString("c_phone"), res.getString("c_address"), 
							res.getInt("isdeal"));
					list.add(adminorder);
				}
				adminorder_pageBean.setData(list);
				int totalRecord = jdbcutil.getCount(sqlcount);
				adminorder_pageBean.setTotalRecord(totalRecord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return adminorder_pageBean;
	}
	@Override
	public boolean delAdminOrderById(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from admin_order where id=?";
		Object[] params = {id};
		int num = jdbcutil.exeUpdate(sql, params);
		if(num>0)
			flag = true;
		return flag ;
	}
	@Override
	public boolean updateAdminOrderById(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update admin_order set isdeal=1 where id=?";
		Object[] params = {id};
		int num = jdbcutil.exeUpdate(sql, params);
		if(num>0)
			flag = true;
		return flag;
	}

}
