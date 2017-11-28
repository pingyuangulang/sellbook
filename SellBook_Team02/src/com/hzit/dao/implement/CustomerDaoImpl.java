package com.hzit.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hzit.dao.interfaces.ICustomerDao;
import com.hzit.entity.Customer;
import com.hzit.util.dbutil.JDBCObject;
import com.hzit.util.dbutil.JDBCUtil;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class CustomerDaoImpl implements ICustomerDao {
	//注入数据库操作工具类
	JDBCUtil jdbcutil = new JDBCUtil();
	//用户Customer注册方法
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "insert into customer values(null,?,?,?,?)";
		Object[] params = {customer.getC_name(),customer.getPassword(),
				customer.getPhone(),customer.getAddress()};
		int num = jdbcutil.exeUpdate(sql, params);
		return (num>0?true:false);
	}
	//通过姓名查找用户
	@Override
	public Customer queryCustomerByName(String c_name) {
		// TODO Auto-generated method stub
		Customer customer = null;
		JDBCObject jdbc = null;
		String sql = "select * from customer where c_name=?";
		Object[] params = {c_name};
		jdbc = jdbcutil.exeQuery(sql, params);
		ResultSet res = jdbc.getRes();
		try {
			if(res.next())
				customer = new Customer(res.getInt("id"), res.getString("c_name"),
						new String(Base64.decode(res.getString("password"))),//将从数据库中取出的密码进行解密
						res.getString("phone"), res.getString("address"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Base64DecodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}
	@Override
	public boolean updateCustomerInfo(Customer customer) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update customer set password=?,phone=?,address=? where id=?";
		Object[] params = {Base64.encode(customer.getPassword().getBytes(), 0),customer.getPhone(),
				customer.getAddress(),customer.getId()};
		int num = jdbcutil.exeUpdate(sql, params);
		if(num>0)
			flag = true;
		else
			flag = false;
		return flag;
	}

}
