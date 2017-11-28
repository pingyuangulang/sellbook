package com.hzit.biz.implement;

import com.hzit.biz.interfaces.IBookBiz;
import com.hzit.dao.implement.BookDaoImpl;
import com.hzit.dao.interfaces.IBookDao;
import com.hzit.entity.Book;
import com.hzit.util.pageutil.PageBean;

public class BookBizImpl implements IBookBiz {
	//注入数据访问层
	IBookDao bookdao = new BookDaoImpl();
	@Override
	public PageBean<Book> getBookListByPage(PageBean<Book> pageBean,String type) {
		// TODO Auto-generated method stub
		return bookdao.getBookListByPage(pageBean,type);
	}
	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookdao.getBookById(id);
	}

}
