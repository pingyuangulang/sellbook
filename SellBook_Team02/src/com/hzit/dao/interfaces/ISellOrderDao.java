package com.hzit.dao.interfaces;

import com.hzit.entity.SellOrder;
import com.hzit.entity.UnionOrderAndBook;
import com.hzit.util.pageutil.PageBean;

public interface ISellOrderDao {
	public boolean addBookToShopCar(SellOrder sellorder);//添加到购物车
	public PageBean<UnionOrderAndBook> getSellOrderByCustomerId(int c_id,PageBean<UnionOrderAndBook> pageBean);//依据用户c_id查询订单,并分页
	public boolean delSellOrderById(int id);//根据订单ID删除订单
	public boolean byBook(int sellorderid);//购买书籍，将订单表中的ispay改为1，书籍表中修改库存=原库存-购买数量
	public SellOrder getSellOrderById(int id);//根据ID查客户订单
}
