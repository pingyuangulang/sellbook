<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册页面</title>
    <style type="text/css">
  body{
  		background-image: url(../../images/bgimg_reg.jpg);
		background-repeat: no-repeat;
		background-size: 100% 100%;
  	}
  #top{
  		position:relative;
  		top:20px;
  		font:100px '华文行楷';
  		color:#5B5B5B;
  	}
  #title{
  		width:300px;
  		position:relative;
  		top:160px;
  		left:60%;
  		font:50px '幼圆';
  		color:#5B5B5B;
  	}
  #content{
  		width:600px;
  		position:relative;
  		top:30px;
  		left:20%;
  		text-align: left;
  	}
  #tab{
  		cellpadding:0;
  		cellspacing:0;
  }
  tr{
  	height:45px;
  	font:18px '幼圆';
  }
  #reg{
  	border:0px;
	width:140px;
	height:50px;
 	background-color:transparent;
 	font-family: '幼圆';
 	font-size:18px;
  }
  #logq{
  	border:0px;
	width:150px;
	height:50px;
 	background-color:transparent;
 	font-family: '幼圆';
 	font-size:18px;
  }
  </style>
    <script type="text/javascript" src="../../js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="../../js/customer/js_for_cus_register.js"></script>
  </head>
  <body>
 	<%
  	//注册失败提示信息
  	String cusregister = (String)request.getSession().getAttribute("cusregister");
   %>
   <div id="top"><img src="../../images/base_logo.png" style="height: 70px; width: 85px; ">图书销售系统 </div>
   <br/><hr size="2px" color="#5B5B5B"/>
  	<div align="center"><%=cusregister==null?"":cusregister %></div>
  	<%
  	request.getSession().removeAttribute("cusregister");
  	%>
  	<div id="title"><b>< </b>用户注册 </div>
	<form action="/SellBook_Team02/servlet/CustomerRegisterServlet" method="post" onsubmit="return authSubmit()">
		<div align="center" id="content">
			<table cellpadding="0" cellspacing="0">
				<tr><td><img src="../../images/person_logo.png" style="height: 35px; width: 35px;"></td>
				<td align="center">用&nbsp;户&nbsp;名：</td>
				<td style="width: 160px;"><input id="c_name" name="c_name" type="text" onblur="authC_name()" style="width: 100%;"/></td>
				<td><span id="c_nameMsg"></span></td></tr>
				
				<tr><td><img src="../../images/password_logo.png" style="height: 35px; width: 35px;"></td>
				<td align="center">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
				<td style="width: 160px;"><input id="password" name="password" type="password" onblur="authPassword()" style="width: 100%;"/></td>
				<td><span id="passwordMsg"></span></td></tr>
				
				<tr><td><img src="../../images/repassword_logo.png" style="height: 35px; width: 35px;"></td>
				<td align="center">确认密码：</td>
				<td style="width: 160px;"><input id="repassword" name="repassword" type="password" onblur="authRepassword()" style="width: 100%;"/></td>
				<td><span id="repasswordMsg"></span></td></tr>
				
				<tr><td><img src="../../images/phone_logo.png" style="height: 35px; width: 35px;"></td>
				<td align="center">手&nbsp;机&nbsp;号：</td>
				<td style="width: 160px;"><input id="phone" name="phone" type="text" onblur="authPhone()" style="width: 100%;"/></td>
				<td><span id="phoneMsg"></span></td></tr>
				<tr><td><img src="../../images/authcode_logo.png" style="height: 35px; width: 35px;"></td>
				<td align="center">验&nbsp;证&nbsp;码：</td>
				<td style="width: 160px;"><input type="text" name="authcode" id="authcode" onblur="authAuthcode()" style="width: 30%;"/>
				<img id="img" alt="验证码" src="/SellBook_Team02/servlet/AuthCode" onclick="changeImage(this)" style="cursor: hand;" style="width: 50%;" width="100px"></td>
				<td><span id="authcodeMsg"></span></td></tr>
				<tr><td><img src="../../images/address_logo.png" style="height: 35px; width: 35px;"></td>
				<td align="center">地&nbsp;&nbsp;&nbsp;&nbsp;址：</td>
				<td style="width: 160px;"><input id="address" name="address" type="text"  style="width: 100%;"/></td>
				<td></td></tr>
				<tr><td align="center" colspan="3" style="height: 40px; "><input type="submit" id="reg" value="注册" onMouseOver="this.style.backgroundImage='url(../../images/log_logo.png)'" onMouseOut="this.style.backgroundImage=''"/>
				<input type="button" id="logq" value="快速登录" onClick="toLogin()" onMouseOver="this.style.backgroundImage='url(../../images/logq_logo.png)'" onMouseOut="this.style.backgroundImage=''"/></td></tr>
			</table>
		</div>
	</form>    
  </body>
</html>