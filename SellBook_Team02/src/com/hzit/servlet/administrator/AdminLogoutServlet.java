package com.hzit.servlet.administrator;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogoutServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Enumeration<String> session_aname = session.getAttributeNames();//获取session中所有属性的键名构成的枚举对象
		while(session_aname.hasMoreElements()){
				session.removeAttribute(session_aname.nextElement());//释放所有的session资源
		}
		response.sendRedirect("/SellBook_Team02/index.jsp");
	}

}
