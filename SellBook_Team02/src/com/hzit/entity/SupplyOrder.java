package com.hzit.entity;
//进货订单对应的实体类
public class SupplyOrder {
	private int id;//进货订单编号
	private Supplier supplier;//与supplier表关联的外键
	private Book book;//与book表关联的外键
	private int count;//进货数量
	private float amount;//总价
	public SupplyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplyOrder(int id, Supplier supplier, Book book, int count,
			float amount) {
		super();
		this.id = id;
		this.supplier = supplier;
		this.book = book;
		this.count = count;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getAmount() {
		this.amount = this.count * this.book.getIn_price();//总价=进货单价*数量
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}
