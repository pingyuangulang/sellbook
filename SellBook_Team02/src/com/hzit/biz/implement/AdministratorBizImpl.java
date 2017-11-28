package com.hzit.biz.implement;

import com.hzit.biz.interfaces.IAdministratorBiz;
import com.hzit.dao.implement.AdministratorDaoImpl;
import com.hzit.dao.interfaces.IAdministratorDao;
import com.hzit.entity.Administrator;

public class AdministratorBizImpl implements IAdministratorBiz {
	//注入数据访问层
	IAdministratorDao admindao = new AdministratorDaoImpl();
	@Override
	public Administrator getAdministrator(String a_name, String password) {
		// TODO Auto-generated method stub
		return admindao.getAdministrator(a_name, password);
	}

}
