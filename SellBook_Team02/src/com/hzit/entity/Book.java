package com.hzit.entity;
//书籍对应的实体类
public class Book {
	private int id;//书籍编号
	private String b_name;//书籍名称
	private int quantity;//书籍库存数量
	private float in_price;//书籍进价
	private float out_price;//书籍售价
	private String publish;//出版社
	private String url;//
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int id, String b_name, int quantity, float in_price,
			float out_price, String publish, String url) {
		super();
		this.id = id;
		this.b_name = b_name;
		this.quantity = quantity;
		this.in_price = in_price;
		this.out_price = out_price;
		this.publish = publish;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getIn_price() {
		return in_price;
	}
	public void setIn_price(float in_price) {
		this.in_price = in_price;
	}
	public float getOut_price() {
		return out_price;
	}
	public void setOut_price(float out_price) {
		this.out_price = out_price;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
