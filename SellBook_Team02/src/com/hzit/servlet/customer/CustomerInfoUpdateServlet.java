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

public class CustomerInfoUpdateServlet extends HttpServlet {
	//注入业务逻辑层
	ICustomerBiz cusbiz = new CustomerBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession cus_session = request.getSession();
		Customer customer = (Customer) cus_session.getAttribute("customer");
		String password = request.getParameter("newpwd");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		customer.setPassword(password);
		customer.setPhone(phone);
		customer.setAddress(address);
		if(cusbiz.updateCustomerInfo(customer)){//修改成功
			cus_session.setAttribute("customer", customer);//刷洗session中原有的旧对象customer
			HttpSession cus_update_info = request.getSession();
			cus_update_info.setAttribute("cus_update_info_success", "修改成功");
			response.sendRedirect("/SellBook_Team02/servlet/BookListServlet");
		}else{//修改失败
			HttpSession cus_update_info = request.getSession();
			cus_update_info.setAttribute("cus_update_info_fail", "修改失败");
			response.sendRedirect("/SellBook_Team02/pages/customer/customer_update_info.jsp");
		}
		
	}

}
