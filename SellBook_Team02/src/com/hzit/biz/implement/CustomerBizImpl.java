package com.hzit.biz.implement;

import com.hzit.biz.interfaces.ICustomerBiz;
import com.hzit.dao.implement.CustomerDaoImpl;
import com.hzit.dao.interfaces.ICustomerDao;
import com.hzit.entity.Customer;

public class CustomerBizImpl implements ICustomerBiz {
	//注入数据访问层
	ICustomerDao cusdao = new CustomerDaoImpl();
	//用户Customer注册方法
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cusdao.addCustomer(customer);
	}
	//查询用户
	@Override
	public Customer queryCustomerByName(String c_name) {
		// TODO Auto-generated method stub
		return cusdao.queryCustomerByName(c_name);
	}
	@Override
	public boolean updateCustomerInfo(Customer customer) {
		// TODO Auto-generated method stub
		return cusdao.updateCustomerInfo(customer);
	}

}
