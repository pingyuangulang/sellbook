package com.hzit.util.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//封装JDBC的三大对象对应的类
public class JDBCObject {
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet res = null;
	public JDBCObject() {
	}
	public JDBCObject(Connection con, PreparedStatement pst, ResultSet res) {
		this.con = con;
		this.pst = pst;
		this.res = res;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public PreparedStatement getPst() {
		return pst;
	}
	public void setPst(PreparedStatement pst) {
		this.pst = pst;
	}
	public ResultSet getRes() {
		return res;
	}
	public void setRes(ResultSet res) {
		this.res = res;
	}
}
