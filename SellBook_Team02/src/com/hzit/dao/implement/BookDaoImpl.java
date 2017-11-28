package com.hzit.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hzit.dao.interfaces.IBookDao;
import com.hzit.entity.Book;
import com.hzit.util.dbutil.JDBCObject;
import com.hzit.util.dbutil.JDBCUtil;
import com.hzit.util.pageutil.PageBean;

public class BookDaoImpl implements IBookDao {
	//注入数据库操作工具
	JDBCUtil jdbcutil = new JDBCUtil();
	//获取分页
	@Override
	public PageBean<Book> getBookListByPage(PageBean<Book> pageBean,String type) {
		// TODO Auto-generated method stub
		Book book = null;
		ResultSet res = null;
		List<Book> list = new ArrayList<Book>();//用于存放ResultSet结果集中的记录
		//准备SQL语句
		//第一个？：起始记录编号，从0开始
		//第二个？：每页条数
		String sql = "select * from book where b_name like ? limit ?,?";
		//计算起始记录
		int start = (pageBean.getCurPage()-1)*pageBean.getPageSize();
		//准备？参数值
		Object[] params = {type,start,pageBean.getPageSize()};
		JDBCObject jdbc = jdbcutil.exeQuery(sql, params);
		res = jdbc.getRes();
		try {
			while(res.next()){
				book = new Book(res.getInt("id"), res.getString("b_name"), res.getInt("quantity"),
						res.getFloat("in_price"), res.getFloat("out_price"), 
						res.getString("publish"), res.getString("url"));
				list.add(book);
			}
			pageBean.setData(list);
			//获取总记录数
			String sqlcount = "select count(*) from book where b_name like ?";
			
			pageBean.setTotalRecord(jdbcutil.getCount(sqlcount,type));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcutil.closeAll(jdbc);//关闭资源
		}
		return pageBean;
	}
	//根据ID获取Book，在页面显示书籍详细信息
	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		Book book = null;
		String sql = "select * from book where id=?";
		Object[] params = {id};
		JDBCObject jdbc = jdbcutil.exeQuery(sql, params);
		ResultSet res = jdbc.getRes();
		try {
			if(res.next())
				book = new Book(res.getInt("id"),res.getString("b_name"),res.getInt("quantity"),
						res.getFloat("in_price"),res.getFloat("out_price"),
						res.getString("publish"),res.getString("url"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcutil.closeAll(jdbc);
		}
		return book;
	}

}
