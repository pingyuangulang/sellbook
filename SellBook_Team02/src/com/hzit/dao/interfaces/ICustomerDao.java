package com.hzit.dao.interfaces;

import com.hzit.entity.Customer;

public interface ICustomerDao {
	public boolean addCustomer(Customer customer);//用户Customer注册方法
	public Customer queryCustomerByName(String c_name);//查询用户
	public boolean updateCustomerInfo(Customer customer);//修改用户信息
}
