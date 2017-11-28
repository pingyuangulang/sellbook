package com.hzit.servlet.sellorder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.BookBizImpl;
import com.hzit.biz.implement.SellOrderBizImpl;
import com.hzit.biz.interfaces.IBookBiz;
import com.hzit.biz.interfaces.ISellOrderBiz;

public class ByBookServlet extends HttpServlet {
	//注入业务逻辑层
	ISellOrderBiz sobiz = new SellOrderBizImpl();
	IBookBiz bookbiz = new BookBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("oid"));
		HttpSession session = request.getSession();
		if(sobiz.byBook(id)){//购买成功
			session.setAttribute("isby", "订单已确定，尽快为您发货。");
		}else{
			session.setAttribute("isby", "购买失败，请重新操作。");
		}
		response.sendRedirect("/SellBook_Team02/servlet/QuerySellOrderServlet");
	}

}
