package com.hzit.servlet.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzit.biz.implement.BookBizImpl;
import com.hzit.biz.interfaces.IBookBiz;
import com.hzit.entity.Book;

public class QueryQuantityFromBookServlet extends HttpServlet {
	//注入业务逻辑层
	IBookBiz bookbiz = new BookBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookbiz.getBookById(id);
		out.print(book.getQuantity());//回显库存数量
	}

}
