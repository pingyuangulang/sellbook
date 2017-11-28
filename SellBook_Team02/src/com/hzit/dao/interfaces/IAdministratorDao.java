package com.hzit.dao.interfaces;

import com.hzit.entity.Administrator;

public interface IAdministratorDao {
	public Administrator getAdministrator(String a_name,String password); 
}
