package com.hzit.util.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//操作数据库的类
public class JDBCUtil {
	//====================================================================
	//获取数据库连接,返回Connection对象
	public Connection getConnection(){
		Connection con = null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获得连接
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksell?useUnicode=true&characterEncoding=UTF-8", "root", "jb0310");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	//====================================================================
	//公共的查询方法,返回封装操作数据库三大对象的类对象,在外部使用完ResultSet后,调用closeAll(JDBCObject jdbc)方法关闭资源
	public JDBCObject exeQuery(String sql , Object[] params){
		JDBCObject jdbc = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		Connection con = this.getConnection();
		try {
			pst = con.prepareStatement(sql);
			if(params!=null && params.length > 0)
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			res = pst.executeQuery();
			jdbc = new JDBCObject(con, pst, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		//此处不用finally进行资源关闭是因为在外部要使用到ResultSet
		return jdbc;
	}
	//====================================================================
	//公共的增删改方法,返回受影响的行数
	public int exeUpdate(String sql , Object[] params){
		int num = 0;
		JDBCObject jdbc = null;
		PreparedStatement pst = null;
		Connection con = this.getConnection();
		try {
			//设置事务非自动提交
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);
			}
			num = pst.executeUpdate();
			//提交事务
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				//如果增删改出现异常则进行事务回滚
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			jdbc = new JDBCObject(con, pst, null);
			//关闭资源
			this.closeAll(jdbc);
		}
		return num;
	}
	//====================================================================
	public int getCount(String sql){
		int num = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		con = this.getConnection();
		try {
			pst = con.prepareStatement(sql);
			res = pst.executeQuery();
			if(res.next())
				num = res.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCObject jdbc = new JDBCObject(con, pst, res);
			this.closeAll(jdbc);
		}
		return num;
	}
	//公共的查询获取总记录数
	public int getCount(String sql, Object type){//type：模糊查询中的字符串，或订单查询中的c_id
		int num = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		con = this.getConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setObject(1, type);
			res = pst.executeQuery();
			if(res.next())
				num = res.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCObject jdbc = new JDBCObject(con, pst, res);
			this.closeAll(jdbc);
		}
		return num;
	}
	//====================================================================
	//关闭数据库操作的三大对象资源
	public void closeAll(JDBCObject jdbc){
		if(jdbc==null)
			return;
		if(jdbc.getRes()!=null)
			try {
				jdbc.getRes().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(jdbc.getPst()!=null)
			try {
				jdbc.getPst().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(jdbc.getCon()!=null)
			try {
				jdbc.getCon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
