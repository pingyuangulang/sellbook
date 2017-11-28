<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录页面</title>
     <style type="text/css">
   body{
  		background-image: url(../../images/bgimg_admin.jpg);
		background-repeat: no-repeat;
		background-size: 100% 100%;
  	}
   #top{
  		position:relative;
  		font:100px '华文行楷';
  		color:#5B5B5B;
  	}
  #title{
  		width:400px;
  		position:relative;
  		top:170px;
  		left:800px;
  		font:50px '幼圆';
  		color:#5B5B5B;
  	}
  #content{
  		width:600px;
  		position:relative;
  		top:60px;
  		left:300px;
  		text-align: left;
  	}
  tr{
  	height:50px;
  	font:20px '幼圆';
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
    <script type="text/javascript" src="../../js/administrator/js_for_admin_login.js"></script>
  </head>
  
  <body>
  <%
  //从Cookie中获取姓名和密码
  String a_name = null;
  String password = null;
  Cookie[] cookies = request.getCookies();
  if(cookies!=null)
	  for(Cookie cookie : cookies){
	  	if(cookie.getName().equals("a_name"))
	  		a_name = URLDecoder.decode(cookie.getValue(), "UTF-8");
	  	if(cookie.getName().equals("password"))
	  		password = URLDecoder.decode(cookie.getValue(), "UTF-8");
	  }
   %>
   <div id="top"><img src="../../images/base_logo.png" style="height: 99px; width: 102px; ">图书销售系统 </div>
   <hr size="2px" color="#5B5B5B"/>
    <form action="/SellBook_Team02/servlet/AuthAdministratorLogin" method="post" onsubmit="return resub();">
    	<span id="adminMsg"></span>
    	<div align="left"><font size="6" face="华文行楷" color="red">${sessionScope.adminlogin }</font></div>
    	<%request.getSession().removeAttribute("adminlogin"); %>
    	<div id="title"><b><</b> 管理员登录 </div>
    	<div id="content" align="center">
    	<table align="left">
    		<tr>
    			<td><img src="../../images/person_logo.png" style="height: 35px; width: 35px;"></td>
    			<td align="center">用&nbsp;户&nbsp;名：</td>
    			<td style="width: 160px;"><input type="text" name="a_name" value="<%=a_name==null?"":a_name %>" style="width: 100%;"/></td>
    		</tr>
    		<tr>
    			<td><img src="../../images/password_logo.png" style="height: 35px; width: 35px;"></td>
    			<td align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
    			<td style="width: 160px;"><input type="password" name="password" value="<%=password==null?"":password %>" style="width: 100%;"/></td>
    		</tr>
    		<tr>
    			<td><img src="../../images/authcode_logo.png" style="height: 35px; width: 35px;"></td>
    			<td align="center">验&nbsp;证&nbsp;码：</td>
    			<!-- <td style="width: 160px;"><input type="text" name="authcode" style="width: 35%;"/>
    			<img id="img" alt="验证码" src="/SellBook_Team02/servlet/AuthCode" onclick="changeImag(this)" style="cursor: hand;width: 50%;" width="100px"></td>
    			-->
    			<td style="width: 170px;"><input type="text" name="authcode" id="authcode" style="width: 35%;"/>
				<img id="img" alt="验证码" src="/SellBook_Team02/servlet/AuthCode" onclick="changeImag(this)" style="cursor: hand;" style="width: 50%;" width="100px"></td>
    		</tr>
    		<tr>
    			<td align="center" colspan="3"><input type="checkbox" name="remeberpsw" value="remeberpsw"/>记住密码</td>
    		</tr>
    		<tr>
    			<td align="center" colspan="4" height="50px"><input type="submit" id="log" value="登录" 
    			onMouseOver="this.style.backgroundImage='url(../../images/log_logo.png)'" 
    			onMouseOut="this.style.backgroundImage=''" /></td>
    		</tr>
    	</table>
    	</div>
    </form>
  </body>
</html>
