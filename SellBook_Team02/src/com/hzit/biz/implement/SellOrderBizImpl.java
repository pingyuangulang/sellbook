package com.hzit.biz.implement;

import com.hzit.biz.interfaces.ISellOrderBiz;
import com.hzit.dao.implement.SellOrderDaoImpl;
import com.hzit.dao.interfaces.ISellOrderDao;
import com.hzit.entity.SellOrder;
import com.hzit.entity.UnionOrderAndBook;
import com.hzit.util.pageutil.PageBean;

public class SellOrderBizImpl implements ISellOrderBiz {
	//注入数据访问层
	ISellOrderDao sodao = new SellOrderDaoImpl();
	@Override
	public boolean addBookToShopCar(SellOrder sellorder) {
		// TODO Auto-generated method stub
		return sodao.addBookToShopCar(sellorder);
	}
	@Override
	public PageBean<UnionOrderAndBook> getSellOrderByCustomerId(int c_id,PageBean<UnionOrderAndBook> pageBean) {
		// TODO Auto-generated method stub
		return sodao.getSellOrderByCustomerId(c_id, pageBean);
	}
	@Override
	public boolean delSellOrderById(int id) {
		// TODO Auto-generated method stub
		return sodao.delSellOrderById(id);
	}
	@Override
	public boolean byBook(int sellorderid) {
		// TODO Auto-generated method stub
		return sodao.byBook(sellorderid);
	}

}
