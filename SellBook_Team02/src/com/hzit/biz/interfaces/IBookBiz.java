package com.hzit.biz.interfaces;

import com.hzit.entity.Book;
import com.hzit.util.pageutil.PageBean;

public interface IBookBiz {
	public PageBean<Book> getBookListByPage(PageBean<Book> pageBean,String type);
	public Book getBookById(int id);
}
