package com.hzit.servlet.adminorder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.AdminOrderBizImpl;
import com.hzit.biz.interfaces.IAdminOrderBiz;

public class UpdateAdminOrderServlet extends HttpServlet {
	//注入业务逻辑层
	IAdminOrderBiz aobiz = new AdminOrderBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id  = Integer.parseInt(request.getParameter("id"));
		HttpSession isdeal_session = request.getSession();
		int isdeal = (Integer) isdeal_session.getAttribute("isdeal");
		HttpSession updateMsg = request.getSession();
		if(aobiz.updateAdminOrderById(id)){//处理成功
			updateMsg.setAttribute("updateMsg", "订单已处理，尽快发货吧！");
		}else{//成功失败
			updateMsg.setAttribute("updateMsg", "订单已处理，尽快发货吧！");
		}
		response.sendRedirect("/SellBook_Team02/servlet/AdminOrderListServlet?isdeal="+isdeal);
	}

}
