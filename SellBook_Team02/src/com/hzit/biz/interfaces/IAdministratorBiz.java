package com.hzit.biz.interfaces;

import com.hzit.entity.Administrator;

public interface IAdministratorBiz {
	public Administrator getAdministrator(String a_name,String password);
}
