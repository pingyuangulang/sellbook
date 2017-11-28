package com.hzit.servlet.sellorder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.SellOrderBizImpl;
import com.hzit.biz.interfaces.ISellOrderBiz;
import com.hzit.entity.Book;
import com.hzit.entity.Customer;
import com.hzit.entity.SellOrder;

public class AddSellOrderServlet extends HttpServlet {
	//注入业务逻辑层
	ISellOrderBiz sobiz = new SellOrderBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int count = Integer.parseInt(request.getParameter("quantity"));
		HttpSession cus_session = request.getSession();
		HttpSession book_session = request.getSession();
		Customer customer = (Customer) cus_session.getAttribute("customer");
		Book book = (Book) book_session.getAttribute("book");
		SellOrder sellorder = new SellOrder(0, book, customer, count, 0);
		if(sobiz.addBookToShopCar(sellorder)){
			response.sendRedirect("/SellBook_Team02/servlet/QuerySellOrderServlet");
		}else{
			HttpSession add_sell_order = request.getSession();
			add_sell_order.setAttribute("add_sell_order_fail", "添加到购物车失败！");
			response.sendRedirect("/SellBook_Team02/pages/book/book_detail.jsp");
		}
	}

}
