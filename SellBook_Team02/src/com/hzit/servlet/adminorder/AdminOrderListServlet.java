package com.hzit.servlet.adminorder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzit.biz.implement.AdminOrderBizImpl;
import com.hzit.biz.interfaces.IAdminOrderBiz;
import com.hzit.entity.AdminOrder;
import com.hzit.util.pageutil.PageBean;

public class AdminOrderListServlet extends HttpServlet {
	//注入业务逻辑层
	IAdminOrderBiz aobiz = new AdminOrderBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageSize = request.getParameter("pageSize");
		String curPage = request.getParameter("curPage");
		String deal = request.getParameter("isdeal");
		int isdeal = -1;
		if(deal!=null && deal!="")
			isdeal = Integer.parseInt(deal);
		HttpSession isdeal_session = request.getSession();
		isdeal_session.setAttribute("isdeal", isdeal);
		PageBean<AdminOrder> adminorder_pageBean = new PageBean<AdminOrder>();
		if(pageSize!=null && !pageSize.equals("")){
			adminorder_pageBean.setPageSize(Integer.parseInt(pageSize));
		}
		if(curPage!=null && !curPage.equals("")){
			adminorder_pageBean.setCurPage(Integer.parseInt(curPage));
		}
		adminorder_pageBean = aobiz.getAdminOrder(isdeal,adminorder_pageBean);
		if(adminorder_pageBean!=null && adminorder_pageBean.getTotalRecord()>0){
			if(adminorder_pageBean.getCurPage()>adminorder_pageBean.getTotalPage()){
				adminorder_pageBean.setCurPage(adminorder_pageBean.getTotalPage());
				adminorder_pageBean = aobiz.getAdminOrder(isdeal,adminorder_pageBean);
			}
			if(adminorder_pageBean!=null && adminorder_pageBean.getTotalRecord()>0){
				if(adminorder_pageBean.getPageSize()>adminorder_pageBean.getTotalRecord()){
					adminorder_pageBean.setPageSize(adminorder_pageBean.getTotalRecord());
					adminorder_pageBean = aobiz.getAdminOrder(isdeal,adminorder_pageBean);
				}
			}
		}
		HttpSession adminorder_session = request.getSession();
		adminorder_session.setAttribute("adminorder_pageBean", adminorder_pageBean);
		response.sendRedirect("/SellBook_Team02/pages/administrator/administrator_success_login.jsp");
	}

}
