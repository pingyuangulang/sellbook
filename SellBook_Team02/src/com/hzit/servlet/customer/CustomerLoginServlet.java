package com.hzit.servlet.customer;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.CustomerBizImpl;
import com.hzit.biz.interfaces.ICustomerBiz;
import com.hzit.entity.Customer;

public class CustomerLoginServlet extends HttpServlet {
	//注入业务逻辑层
	private ICustomerBiz cusbiz = new CustomerBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String c_name = request.getParameter("c_name");
		String password = request.getParameter("password");
		String authcode = request.getParameter("authcode");
		String code = (String) session.getAttribute("authcode");
		String remeberpsw = request.getParameter("remeberpsw");
		if(remeberpsw!=null && remeberpsw.equals("remeberpsw")){//如果用户选择了记住密码
			Cookie name_cookie = new Cookie("c_name",URLEncoder.encode(c_name, "UTF-8") );
			Cookie password_cookie = new Cookie("c_password", URLEncoder.encode(password, "UTF-8"));
			name_cookie.setMaxAge(60*60*24*7);
			name_cookie.setPath("/");
			password_cookie.setMaxAge(60*60*24*7);
			password_cookie.setPath("/");
			response.addCookie(password_cookie);
			response.addCookie(name_cookie);
		}
		if(code.equals(authcode)){//验证码正确
			Customer customer = cusbiz.queryCustomerByName(c_name);
			if(customer!=null && customer.getPassword().equals(password)){//登录成功
				HttpSession customer_session = request.getSession();
				customer_session.setAttribute("customer", customer);
				response.sendRedirect("/SellBook_Team02/servlet/BookListServlet");
			}else{//登录失败
				request.getSession().setAttribute("cuslogin", "登录失败，请重新登录");
				response.sendRedirect("/SellBook_Team02/pages/customer/customer_login.jsp");
			}
		}else{//验证码错误
			request.getSession().setAttribute("cuslogin", "登录失败，请重新登录");
			response.sendRedirect("/SellBook_Team02/pages/customer/customer_login.jsp");
		}
	}

}
