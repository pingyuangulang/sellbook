package com.hzit.entity;
//管理员对应的实体类
public class Administrator {
	private int id;//管理员编号
	private String a_name;//管理员姓名
	private String password;//登录密码
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrator(int id, String a_name, String password) {
		super();
		this.id = id;
		this.a_name = a_name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
