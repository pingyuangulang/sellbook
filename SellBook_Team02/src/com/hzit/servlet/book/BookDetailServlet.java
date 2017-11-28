package com.hzit.servlet.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.BookBizImpl;
import com.hzit.biz.interfaces.IBookBiz;
import com.hzit.entity.Book;

public class BookDetailServlet extends HttpServlet {
	//注入业务逻辑层
	IBookBiz bookbiz = new BookBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Book book = bookbiz.getBookById(id);
		HttpSession book_session = request.getSession();
		book_session.setAttribute("book", book);
		response.sendRedirect("/SellBook_Team02/pages/book/book_detail.jsp");
	}

}
