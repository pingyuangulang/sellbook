package com.hzit.entity;

public class AdminOrder {
	private int id;
	private int count;//购买数量
	private float amount;//总价
	private String b_name;//书籍名称
	private String b_url;//图片url
	private String c_name;//客户姓名
	private String c_phone;//客户电话
	private String c_address;//客户收货地址
	private int isdeal;//订单是否已处理0：未处理；1：已处理
	public AdminOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminOrder(int id, int count, float amount, String b_name,
			String b_url, String c_name, String c_phone, String c_address,
			int isdeal) {
		super();
		this.id = id;
		this.count = count;
		this.amount = amount;
		this.b_name = b_name;
		this.b_url = b_url;
		this.c_name = c_name;
		this.c_phone = c_phone;
		this.c_address = c_address;
		this.isdeal = isdeal;
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
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_url() {
		return b_url;
	}
	public void setB_url(String b_url) {
		this.b_url = b_url;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_phone() {
		return c_phone;
	}
	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public int getIsdeal() {
		return isdeal;
	}
	public void setIsdeal(int isdeal) {
		this.isdeal = isdeal;
	}
}
