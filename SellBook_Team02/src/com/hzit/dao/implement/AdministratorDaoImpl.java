package com.hzit.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hzit.dao.interfaces.IAdministratorDao;
import com.hzit.entity.Administrator;
import com.hzit.util.dbutil.JDBCObject;
import com.hzit.util.dbutil.JDBCUtil;

public class AdministratorDaoImpl implements IAdministratorDao {
	//注入数据库操作的工具类
	private JDBCUtil jdbcutil = new JDBCUtil();
	@Override
	public Administrator getAdministrator(String a_name, String password) {
		// TODO Auto-generated method stub
		Administrator administrator = null;
		ResultSet res = null;
		JDBCObject jdbc = null;//用于接收JDBCUtil中exeQuery方法返回值
		String sql = "select id,password from admin where a_name=?";
		Object[] params = {a_name};
		jdbc = jdbcutil.exeQuery(sql, params);//如果不存在此管理员，则jdbc为空
		try{
			res = jdbc.getRes();//获取查询返回的结果集,此处可能会发生空指针异常
			while(res.next()){
				if(password.equals(res.getString("password"))){//此处可能会发生SQL异常
					//将结果集中正确的一行数据封装成Administrator对象
					administrator = new Administrator(res.getInt("id"), a_name, password);
					break;
				}
			}
		} catch (NullPointerException e){
			administrator = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			jdbcutil.closeAll(jdbc);//关闭资源
		}
		return administrator;
	}

}
