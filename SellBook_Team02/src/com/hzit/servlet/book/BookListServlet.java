package com.hzit.servlet.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hzit.biz.implement.BookBizImpl;
import com.hzit.biz.interfaces.IBookBiz;
import com.hzit.entity.Book;
import com.hzit.util.pageutil.PageBean;


public class BookListServlet extends HttpServlet {
	//注入业务逻辑层
	IBookBiz bookbiz = new BookBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取Session对象
		HttpSession curtype = request.getSession();
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		if(type==null || type.equals(""))
			type = "java";
		curtype.setAttribute("curtype", type);
		PageBean<Book> pageBean = new PageBean<Book>();
		//获取客户端请求所携带的每页条数和页数
		String ps = request.getParameter("pageSize");
		if(ps!=null)
			pageBean.setPageSize(Integer.parseInt(ps));
		String pno = request.getParameter("curPage");
		if(pno!=null)
			pageBean.setCurPage(Integer.parseInt(pno));
		//调用业务逻辑层分页列表方法
		pageBean = bookbiz.getBookListByPage(pageBean,"%"+type+"%");
		//如果当前页大于总页数
		if(pageBean.getCurPage()>pageBean.getTotalPage()){
			pageBean.setCurPage(pageBean.getTotalPage());
			pageBean = bookbiz.getBookListByPage(pageBean,"%"+type+"%");
		}
		//如果页面条数大于总记录数
		if(pageBean.getPageSize()>pageBean.getTotalRecord()){
			pageBean.setPageSize(pageBean.getTotalRecord());
			pageBean = bookbiz.getBookListByPage(pageBean,"%"+type+"%");
		}
		//将结果pageBean对象存入会话对象session中
		session.setAttribute("pageBean", pageBean);
		//响应视图
		response.sendRedirect("/SellBook_Team02/pages/customer/customer_success_login.jsp");
	}

}
