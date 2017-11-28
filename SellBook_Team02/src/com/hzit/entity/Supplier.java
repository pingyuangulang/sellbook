package com.hzit.entity;
//供应商对应的实体类
public class Supplier {
	private int id;//编号主键
	private String s_name;//供应商姓名
	private String phone;//供应商电话
	private String address;//供应商地址
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(int id, String s_name, String phone, String address) {
		super();
		this.id = id;
		this.s_name = s_name;
		this.phone = phone;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
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
