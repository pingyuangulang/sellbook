package com.hzit.servlet.sellorder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.SellOrderBizImpl;
import com.hzit.biz.interfaces.ISellOrderBiz;

public class SellOrderDelServlet extends HttpServlet {
	//注入业务逻辑层
	ISellOrderBiz sobiz = new SellOrderBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));//获取订单id
		HttpSession session = request.getSession();
		if(sobiz.delSellOrderById(id)){
			session.setAttribute("orderisdel", "删除成功！");
		}
		else{
			session.setAttribute("orderisdel", "删除失败！");
		}
		response.sendRedirect("/SellBook_Team02/servlet/QuerySellOrderServlet");
	}

}
