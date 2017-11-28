package com.hzit.servlet.administrator;
//管理员登录Servlet
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hzit.biz.implement.AdministratorBizImpl;
import com.hzit.biz.interfaces.IAdministratorBiz;
import com.hzit.entity.Administrator;

public class AuthAdministratorLogin extends HttpServlet {
	//注入业务逻辑层
	private IAdministratorBiz adminbiz = new AdministratorBizImpl();
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取表单数据
		String a_name = request.getParameter("a_name");
		String password = request.getParameter("password");
		String authcode = request.getParameter("authcode");
		String remeberpsw = request.getParameter("remeberpsw");
		HttpSession code_session = request.getSession();//获取验证码Servlet中的验证码的session对象
		//如果选择了记住密码，就将密码和用户名保存到Cookie中，保存一周
		if(remeberpsw!=null && remeberpsw.equals("remeberpsw")){
			Cookie name_cookie = new Cookie("a_name",URLEncoder.encode(a_name, "UTF-8") );
			Cookie password_cookie = new Cookie("password", URLEncoder.encode(password, "UTF-8"));
			name_cookie.setMaxAge(60*60*24*7);
			name_cookie.setPath("/");
			password_cookie.setMaxAge(60*60*24*7);
			password_cookie.setPath("/");
			response.addCookie(password_cookie);
			response.addCookie(name_cookie);
		}
		//如果验证码输入正确
		if(authcode!=null && authcode.equals((String)code_session.getAttribute("authcode"))){
			Administrator administrator = adminbiz.getAdministrator(a_name, password);
			if(administrator!=null){//条件成立表示登录成功
				HttpSession admin_session = request.getSession();//存放管理员对象的session
				admin_session.setAttribute("administrator", administrator);
				response.sendRedirect("/SellBook_Team02/servlet/AdminOrderListServlet");//重定向到登录成功的页面
			}else{//数据库中不存在此人，登录失败
				HttpSession msg = request.getSession();
				msg.setAttribute("adminlogin", "登录失败，请重新登录");
				response.sendRedirect("/SellBook_Team02/pages/administrator/administrator_login.jsp");//重定向到登录失败页面
			}
		}else{//验证码错误，登录失败，回到登录页面
			HttpSession msg = request.getSession();
			msg.setAttribute("adminlogin", "登录失败，请重新登录");
			response.sendRedirect("/SellBook_Team02/pages/administrator/administrator_login.jsp");//重定向到登录失败页面
		}
	}

}
