package com.hzit.biz.implement;

import com.hzit.biz.interfaces.IAdminOrderBiz;
import com.hzit.dao.implement.AdminOrderDaoImpl;
import com.hzit.dao.interfaces.IAdminOrderDao;
import com.hzit.entity.AdminOrder;
import com.hzit.util.pageutil.PageBean;

public class AdminOrderBizImpl implements IAdminOrderBiz {
	//注入数据访问层
	IAdminOrderDao aodao = new AdminOrderDaoImpl();
	@Override
	public PageBean<AdminOrder> getAdminOrder(int isdeal,PageBean<AdminOrder> adminorder_pageBean) {
		// TODO Auto-generated method stub
		return aodao.getAdminOrder(isdeal,adminorder_pageBean);
	}
	@Override
	public boolean delAdminOrderById(int id) {
		// TODO Auto-generated method stub
		return aodao.delAdminOrderById(id);
	}
	@Override
	public boolean updateAdminOrderById(int id) {
		// TODO Auto-generated method stub
		return aodao.updateAdminOrderById(id);
	}

}
