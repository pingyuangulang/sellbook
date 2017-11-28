package com.hzit.util.pageutil;

import java.util.List;

/**
 * 公共的分页类
 * @author 吉彬
 *
 */
public class PageBean<T> {
	private int curPage = 1; //当前页，默认第一页
	private int pageSize = 5; //每页的条数
	private int totalRecord; //总记录数
	private int totalPage; //总页数
	private List<T> data; //当前页列表信息
	//---------------------------------------------
	public PageBean() {
		super();
	}
	//---------------------------------------------
	public PageBean(int curPage, int pageSize, int totalRecord, int totalPage,
			List<T> data) {
		super();
		this.curPage = curPage;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.data = data;
	}
	//---------------------------------------------
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	//---------------------------------------------
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//---------------------------------------------
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	//---------------------------------------------
	public int getTotalPage() {
		if(this.getTotalRecord()%this.getPageSize()!=0)
			this.totalPage = this.getTotalRecord()/this.getPageSize()+1;
		else
			this.totalPage = this.getTotalRecord()/this.getPageSize();
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	//---------------------------------------------
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	//---------------------------------------------
}
