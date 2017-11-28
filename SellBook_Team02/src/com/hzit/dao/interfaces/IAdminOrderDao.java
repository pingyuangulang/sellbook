package com.hzit.dao.interfaces;

import com.hzit.entity.AdminOrder;
import com.hzit.util.pageutil.PageBean;

public interface IAdminOrderDao {
	public PageBean<AdminOrder> getAdminOrder(int isdeal,PageBean<AdminOrder> adminorder_pageBean);//0:未处理；1:已处理；其他：全部订单
	public boolean delAdminOrderById(int id);//通过Id删除订单
	public boolean updateAdminOrderById(int id);//通过id修改admin_order表
}
