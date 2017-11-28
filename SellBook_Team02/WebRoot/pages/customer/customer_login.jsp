<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
    <style type="text/css">
   body{
  		background-image: url(../../images/bgimg_log.jpg);
		background-repeat: no-repeat;
		background-size: 100% 99%;
  	}
   #top{
  		position:relative;
  		top:20px;
  		font:100px '华文行楷';
  		color:#5B5B5B;
  	}
  #title{
  		width:300px;
  		height:50px;
  		position:relative;
  		top:190px;
  		left:320px;
  		font:50px '幼圆';
  		color:#5B5B5B;
  	}
  #content{
  		width:600px;
  		height:300px;
  		position:relative;
  		top:50px;
  		left:700px;
  		text-align: left;
  	}
  tr{
  	height:50px;
  	font:18px '幼圆';
  }
  #log{
	border:0px;
	width:140px;
	height:50px;
 	background-color:transparent;
 	font-family: '幼圆';
 	font-size:18px;
  }
  </style>
    <script type="text/javascript" src="../../js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="../../js/customer/js_for_cus_login.js"></script>
  </head>
  
  <body>
  <%
  //从Cookie中获取姓名和密码
  String c_name = null;
  String password = null;
  Cookie[] cookies = request.getCookies();
  if(cookies!=null){
	  for(Cookie cookie : cookies){
	  	if(cookie.getName().equals("c_name"))
	  		c_name = URLDecoder.decode(cookie.getValue(), "UTF-8");
	  	if(cookie.getName().equals("c_password"))
	  		password = URLDecoder.decode(cookie.getValue(), "UTF-8");
	  }
    }
   %>
   <%
   		String cuslogin = (String)request.getSession().getAttribute("cuslogin");//登录失败提示信息
   		String cusregister = (String)request.getSession().getAttribute("cusregister");//注册成功提示信息
    %>
    <div id="top"><img src="../../images/base_logo.png" style="height: 80px; width: 95px; ">图书销售系统 </div>
		<hr size="2px" color="#5B5B5B"/>
		<div align="right" style="margin-right: 300px;"><font size="6" face="华文行楷" color="red">
		<%=cuslogin==null?"":cuslogin %></font></div>
		<div align="right" style="margin-right: 300px;"><font size="6" face="华文行楷" color="red">
		<%=cusregister==null?"":cusregister %></font></div>
		<%
		request.getSession().removeAttribute("cusregister");
		request.getSession().removeAttribute("cuslogin");
		 %>
		<div id="title">用户登录 <b>&gt;</b></div>
    <form action="/SellBook_Team02/servlet/CustomerLoginServlet" method="post" onsubmit="return login()">
    	<div align="center" id="content">
    	<div align="right" style="margin-top: 20px;margin-right: 300px;">
		<span id="cusMsg" ></span></div><!-- 校验验证码 -->
    	<table align="right" style="margin-right: 200px;">
    		<tr>
    			<td><img src="../../images/person_logo.png" style="height: 35px; width: 35px;"></td>
    			<td align="center">用&nbsp;户&nbsp;名：</td>
    			<td style="width: 160px;"><input type="text" name="c_name" value="<%=c_name==null?"":c_name %>" style="width: 100%;"/></td>
    		</tr>
    		<tr>
    			<td><img src="../../images/password_logo.png" style="height: 35px; width: 35px;"></td>
    			<td align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
    			<td style="width: 160px;"><input type="password" name="password" value="<%=password==null?"":password %>" style="width: 100%;"/></td>
    		</tr>
    		<tr>
    			<td><img src="../../images/authcode_logo.png" style="height: 35px; width: 35px;"></td>
    			<td align="center">验&nbsp;证&nbsp;码：</td>
				<td style="width: 160px;"><input type="text" name="authcode" id="authcode" onkeyup="authAuthcode()" style="width: 31%;"/>
				<img id="img" alt="验证码" src="/SellBook_Team02/servlet/AuthCode" onclick="changeImag(this)" style="cursor: hand;" style="width: 50%;" width="100px"></td>
    		</tr>
    		<tr>
    			<td align="center" colspan="3"><input type="checkbox" name="remeberpsw" value="remeberpsw"/>记住密码</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4"><input type="submit" id="log" value="登录" 
    			onMouseOver="this.style.backgroundImage='url(../../images/log_logo.png)'" 
    			onMouseOut="this.style.backgroundImage=''"/></td>
    		</tr>
    	</table>
    	</div>
	</form>
  </body>
</html>
