package com.hzit.servlet.adminorder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.AdminOrderBizImpl;
import com.hzit.biz.interfaces.IAdminOrderBiz;

public class DelAdminOrderServlet extends HttpServlet {
	//注入业务逻辑层
	IAdminOrderBiz aobiz = new AdminOrderBizImpl();
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession isdeal_session = request.getSession();
		int isdeal = (Integer) isdeal_session.getAttribute("isdeal");
		HttpSession delMsg = request.getSession();
		if(aobiz.delAdminOrderById(id)){//删除AdminOrder订单
			delMsg.setAttribute("delMsg", "删除成功！");
		}
		else{
			delMsg.setAttribute("delMsg", "删除失败！");
		}
		response.sendRedirect("/SellBook_Team02/servlet/AdminOrderListServlet?isdeal="+isdeal);
	}

}
