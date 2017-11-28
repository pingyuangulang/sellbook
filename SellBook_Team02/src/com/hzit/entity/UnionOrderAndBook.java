package com.hzit.entity;

public class UnionOrderAndBook {
	private int id;//出售订单表id
	private int count;//购买或加入购物车某本数的数量
	private float amount;//总价
	private int ispay;//是否已付款，1：已付款；0：未付款
	private int b_id;//图书编号
	private String b_name;//书籍名称
	private float out_price;//书籍售价
	private String url;//书籍对应图片的URL
	public UnionOrderAndBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UnionOrderAndBook(int id, int count, float amount, int ispay,
			int b_id, String b_name, float out_price, String url) {
		super();
		this.id = id;
		this.count = count;
		this.amount = amount;
		this.ispay = ispay;
		this.setB_id(b_id);
		this.b_name = b_name;
		this.out_price = out_price;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public float getOut_price() {
		return out_price;
	}
	public void setOut_price(float out_price) {
		this.out_price = out_price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
