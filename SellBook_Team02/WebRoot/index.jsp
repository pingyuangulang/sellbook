<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书销售主页</title>
   <script type="text/javascript">
  	function cusreg(){
  		window.open("pages/customer/customer_register.jsp","_self");
  	}
  	function cuslog(){
  		window.open("pages/customer/customer_login.jsp", "_self");
  	}
  	function adlog(){
  		window.open("pages/administrator/administrator_login.jsp", "_self");
  	}
  </script>
  <style type="text/css">
  body{
  	background-image: url("images/bgcolor.png");
  }
  #top{
  		position:relative;
  		top:20px;
  		font:80px '华文行楷';
  		color:#5B5B5B;
  }
  #select{
  		position:relative;
  		top:50px;
  }
   #cusreg{
 	border:0px;
 	background-color:transparent;
 	width:300px;
 	height:100px;
 	font-size:30px;
 	color:#5B5B5B;
 	font-family: '幼圆';
    font-weight:bold;
 }
 #cuslog{
 	border:0px;
 	background-color:transparent;
 	width:300px;
 	height:100px;
 	font-size:30px;
 	color:#5B5B5B;
 	font-family: '幼圆';
    font-weight:bold;
 }
 #adlog{
 	border:0px;
 	background-color:transparent;
 	width:300px;
 	height:100px;
 	font-size:30px;
 	color:#5B5B5B;
 	font-family: '幼圆';
    font-weight:bold;
 }
 #deer{
  		position:absolute;
  		top:45%;
  		left:5%;
  	}
  </style>
  </head>
  
  <body>
  <div align="center" id="top">欢迎进入图书销售系统<hr size="5px" width="70%" color="#5B5B5B"/></div>
  		<div id="deer">
  		<img src="images/img_deer.png" style="height: 300px; width: 300px; ">
  		</div>
  		<div align="center" id="select">
  			<input type="button" id="cusreg" value="用户注册" onClick="cusreg()" onMouseOver="this.style.backgroundImage='url(images/ring_logo.png)'" onMouseOut="this.style.backgroundImage=''"/>
  			<br/><input type="button" id="cuslog" value="用户登录" onClick="cuslog()" onMouseOver="this.style.backgroundImage='url(images/ring_logo.png)'" onMouseOut="this.style.backgroundImage=''"/>
  			<br/><input type="button" id="adlog" value="管理员登录" onClick="adlog()" onMouseOver="this.style.backgroundImage='url(images/ring_logo.png)'" onMouseOut="this.style.backgroundImage=''"/>
  		</div>
  </body>
</html>
