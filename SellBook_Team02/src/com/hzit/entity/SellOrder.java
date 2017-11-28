package com.hzit.entity;
//出售订单对应的实体类
public class SellOrder {
	private int id;//出售订单编号
	private Book book;//与book表关联的外键
	private Customer customer;//与customer表关联的外键
	private int count;//书籍数量
	private float amount;//总价
	private int ispay;//是否以付款，1表示已付款，0表示未付款
	public SellOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellOrder(int id, Book book, Customer customer, int count,
			int ispay) {
		super();
		this.id = id;
		this.book = book;
		this.customer = customer;
		this.count = count;
		this.amount = this.count * this.book.getOut_price();//总价=数量*出售单价
		this.ispay = ispay;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getIspay() {
		return ispay;
	}
	public void setIspay(int ispay) {
		this.ispay = ispay;
	}
}
