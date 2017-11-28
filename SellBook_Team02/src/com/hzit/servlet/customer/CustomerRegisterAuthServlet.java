package com.hzit.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzit.biz.implement.CustomerBizImpl;
import com.hzit.biz.interfaces.ICustomerBiz;
import com.hzit.entity.Customer;

public class CustomerRegisterAuthServlet extends HttpServlet {
	//注入业务逻辑层
	ICustomerBiz cusbiz = new CustomerBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer customer = null;
		PrintWriter out = response.getWriter();
		String c_name = request.getParameter("c_name");
		customer = cusbiz.queryCustomerByName(c_name);
		if(customer==null){//此用户名不存在，可以注册
			out.print(true);
		}else{//此用户名已存在，不能注册
			out.print(false);
		}
	}

}
