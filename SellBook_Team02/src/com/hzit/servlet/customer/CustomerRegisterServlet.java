package com.hzit.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.CustomerBizImpl;
import com.hzit.biz.interfaces.ICustomerBiz;
import com.hzit.entity.Customer;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class CustomerRegisterServlet extends HttpServlet {
	//注入业务逻辑层
	ICustomerBiz cusbiz = new CustomerBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession authcodesession = request.getSession();
		String authcode = (String) authcodesession.getAttribute("authcode");
		String code = request.getParameter("authcode");
		if(code!=null && code.equals(authcode)){
			String c_name = request.getParameter("c_name");
			String password = Base64.encode(request.getParameter("password").getBytes(), 0);
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			Customer customer = new Customer(0, c_name, password, phone, address);
			if(cusbiz.addCustomer(customer)){
				request.getSession().setAttribute("cusregister", "注册成功，请登录");
				response.sendRedirect("/SellBook_Team02/pages/customer/customer_login.jsp");
			}
			else{
				request.getSession().setAttribute("cusregister", "注册失败");
				response.sendRedirect("/SellBook_Team02/pages/customer/customer_register.jsp");
			}
		}else{
			request.getSession().setAttribute("cusregister", "注册失败");
			response.sendRedirect("/SellBook_Team02/pages/customer/customer_register.jsp");
		}
	}

}
