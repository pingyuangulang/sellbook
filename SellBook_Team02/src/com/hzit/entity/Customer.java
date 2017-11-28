package com.hzit.entity;
//顾客对应的实体类
public class Customer {
	private int id;//顾客编号
	private String c_name;//顾客姓名
	private String password;//顾客登录密码（注册时需进行加密）
	private String phone;//顾客电话
	private String address;//顾客地址
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String c_name, String password, String phone,
			String address) {
		super();
		this.id = id;
		this.c_name = c_name;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
