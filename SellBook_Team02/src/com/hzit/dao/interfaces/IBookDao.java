package com.hzit.dao.interfaces;

import com.hzit.entity.Book;
import com.hzit.util.pageutil.PageBean;

public interface IBookDao {
	public PageBean<Book> getBookListByPage(PageBean<Book> pageBean,String type);//对书籍进行分页
	public Book getBookById(int id);//通过id获取书籍
	
}
