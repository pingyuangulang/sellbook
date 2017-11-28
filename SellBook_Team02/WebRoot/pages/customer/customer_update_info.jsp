<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户修改信息页面</title>
    <style type="text/css">
 body{
  		background-image: url(../../images/bgimg.jpg);
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
  		position:relative;
  		top:190px;
  		left:320px;
  		font:50px '幼圆';
  		color:#5B5B5B;
  	}
  #content{
  		width:600px;
  		position:relative;
  		top:20px;
  		left:650px;
  		text-align: left;
  	}
  tr{
  	height:50px;
  	font:18px '幼圆';
  }
  #update{
  	border:0px;
	width:140px;
	height:50px;
 	background-color:transparent;
 	font-family: '幼圆';
 	font-size:18px;
  }
  #back{
  	border:0px;
	width:100px;
	height:50px;
 	background-color:transparent;
 	font-family: '幼圆';
 	font-size:18px;
  }
  </style>
	<script type="text/javascript" src="../../js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="../../js/customer/js_for _cus_update_info.js"></script>
  </head>
  
  <body>
  <div id="top"><img src="../../images/base_logo.png" style="height: 80px; width: 95px; ">图书销售系统 </div>
  <br/><hr size="2px" color="#5B5B5B"/>
  <div align="center"><font size="4" face="华文行楷" color="red">${sessionScope.cus_update_info_fail }</font></div>
  <div id="title">修改信息 <b>></b></div>
    <form action="/SellBook_Team02/servlet/CustomerInfoUpdateServlet" method="post" onsubmit="return issubmit()">
    	<div align="center" id="content">
    	<table align="center" cellpadding="0" cellspacing="0" style="margin-top: 10px;">
    		<tr><td style="width: 50px; "><img src="../../images/oldpwd_logo.png" style="height: 35px; width: 35px;"></td>
    		<td align="center">原始密码：</td>
    		<td><input type="password" id="oldpwd" name="oldpwd" onblur="authOldPassword('${sessionScope.customer.password}')"/></td>
    		<td><span id="oldpwdMsg"></span></td></tr>
    		<tr><td style="width: 50px; "><img src="../../images/password_logo.png" style="height: 35px; width: 35px;"></td>
    		<td align="center">新&nbsp;密&nbsp;码：</td>
    		<td><input type="password" id="newpwd" name="newpwd" onblur="authNewPassword()"/></td>
    		<td><span id="newpwdMsg"></span></td></tr>
    		<tr><td style="width: 50px; "><img src="../../images/repassword_logo.png" style="height: 35px; width: 35px;"></td>
    		<td align="center">确认密码：</td>
    		<td><input type="password" id="renewpwd" name="renewpwd" onkeyup="authReNewPassword()"/></td>
    		<td><span id="repwdMsg"></span></td></tr>
    		<tr><td style="width: 50px; "><img src="../../images/phone_logo.png" style="height: 35px; width: 35px;"></td>
    		<td align="center">手&nbsp;机&nbsp;号：</td>
    		<td><input type="text" id="phone" name="phone" value="${sessionScope.customer.phone }" onkeyup="authPhone()"/></td>
    		<td><span id="phoneMsg"></span></td></tr>
    		<tr><td style="width: 50px; "><img src="../../images/address_logo.png" style="height: 35px; width: 35px;"></td>
    		<td align="center">收货地址：</td>
    		<td><input type="text" name="address" value="${sessionScope.customer.address }"/></td>
    		<td></td></tr>
    		<tr><td align="center" colspan="3" height="50px">
    			<input type="submit" id="update" value="修改" onMouseOver="this.style.backgroundImage='url(../../images/log_logo.png)'" onMouseOut="this.style.backgroundImage=''"/>
    			<input type="button" id="back" value="返回" onClick="gotoBookListServlet('${sessionScope.curtype}')" onMouseOver="this.style.backgroundImage='url(../../images/logq_logo.png)'" onMouseOut="this.style.backgroundImage=''"/>
    		</td></tr>
    	</table>
    	</div>
    </form>
  </body>
</html>
