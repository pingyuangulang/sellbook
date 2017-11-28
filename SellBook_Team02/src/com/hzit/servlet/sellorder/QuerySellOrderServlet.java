package com.hzit.servlet.sellorder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.SellOrderBizImpl;
import com.hzit.biz.interfaces.ISellOrderBiz;
import com.hzit.entity.Customer;
import com.hzit.entity.UnionOrderAndBook;
import com.hzit.util.pageutil.PageBean;

public class QuerySellOrderServlet extends HttpServlet {
	//注入业务逻辑层
	ISellOrderBiz sobiz = new SellOrderBizImpl();
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession cus_session = request.getSession();
		Customer customer = (Customer) cus_session.getAttribute("customer");
		PageBean<UnionOrderAndBook> order_pageBean = new PageBean<UnionOrderAndBook>();
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		
			if(curPage!=null)
				order_pageBean.setCurPage(Integer.parseInt(curPage));
			
			if(pageSize!=null)
				order_pageBean.setPageSize(Integer.parseInt(pageSize));
			
			order_pageBean = sobiz.getSellOrderByCustomerId(customer.getId(),order_pageBean);
			if(order_pageBean!=null && order_pageBean.getTotalRecord()>0){
				if(order_pageBean.getCurPage()>order_pageBean.getTotalPage()){
					order_pageBean.setCurPage(order_pageBean.getTotalPage());
					order_pageBean = sobiz.getSellOrderByCustomerId(customer.getId(),order_pageBean);
				}
				if(order_pageBean!=null && order_pageBean.getTotalRecord()>0){
					if(order_pageBean.getPageSize()>order_pageBean.getTotalRecord()){
						order_pageBean.setPageSize(order_pageBean.getTotalRecord());
						order_pageBean = sobiz.getSellOrderByCustomerId(customer.getId(),order_pageBean);
					}
				}
			}
		//不管有没有订单都跳到订单显示页面，将order_pageBean存放在session中，在订单显示页面判断order_pageBean是否为空
			HttpSession order_pageBean1 = request.getSession();
			order_pageBean1.setAttribute("order_pageBean", order_pageBean);
		response.sendRedirect("/SellBook_Team02/pages/sellorder/sellorder_suc_add.jsp");
	}

}
