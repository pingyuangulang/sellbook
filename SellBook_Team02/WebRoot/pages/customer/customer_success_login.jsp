<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录成功后主页</title>
    
    <style type="text/css">
   body{
   		background-image:url(../../images/bgcolor.png);
   }
   #top{
 		width:98%;
  		position:relative;
  		left:2%;
  		font:50px '华文行楷';
  		color:#5B5B5B;
  	}
  	#top_right{
  		margin-right:2%;
  		float:right;
  	}
  	#set{
  		width:150px;
  		position:fixed;
  		margin-top:2%;
  		margin-left:85%;
  	}
  	#select{
  		margin-right:5%;
  	}
  	#deerl{
  		width:400px;
  		position:fixed;
  		top:65%;
  	}
  	#deerr{
  		width:250px;
  		position:fixed;
  		top:65%;
  		left:82%;
  	}
  </style>
    <script type="text/javascript" src="../../js/jquery-1.4.2.js"></script>
    <script type="text/javascript">
  		var curPage = ${sessionScope.pageBean.curPage};//当前页
		var pageSize = ${sessionScope.pageBean.pageSize};//页面大小
    	var totalPage = ${sessionScope.pageBean.totalPage};//总页数
    	var totalRecord = ${sessionScope.pageBean.totalRecord};//总记录数
    </script>
    <script type="text/javascript" src="../../js/customer/js_for_cus_success_login.js"></script>
  </head>
  
  <!-- <body bgcolor="#F0F0F0">
  <div>
    <div align="right" style="margin-right: 30px;">
    	<font size="4" face="华文行楷" color="#FF9900">你好：${sessionScope.customer.c_name }</font>
    	<a href="/SellBook_Team02/servlet/QuerySellOrderServlet">我的购物车</a>
    	<a href="customer_update_info.jsp">修改信息</a>
    	<a href="/SellBook_Team02/servlet/CustomerLogoutServlet">退出</a>
    </div>
    <div id="top"><img src="../../images/base_logo.png" style="height: 62px; width: 64px; ">图书销售系统 </div>
    </div>
    <hr style="height: 10px;" color="green"/>
  <div><font size="6" face="华文行楷" color="#ff9900">${sessionScope.cus_update_info_success }</font></div>
  <%//request.getSession().removeAttribute("cus_update_info_success"); %>
    <div align="center" style="margin-bottom: 10px;"><font size="6px" face="华文行楷" color="cyan">
    <a href="/SellBook_Team02/servlet/BookListServlet?type=java">java</a>
    <a href="/SellBook_Team02/servlet/BookListServlet?type=python">python</a>
    <a href="/SellBook_Team02/servlet/BookListServlet?type=c">c/c++</a></font></div>
    <hr color="cyan" style="height: 10px;width: 300px" align="center"/>
    <table align="center" style="margin-top: 30px;" border="1" cellpadding="2" cellspacing="2" width="60%">
    	<tr>
    		<th>图片</th>
    		<th>书名</th>
    		<th>价格(元)</th>
    		<th>出版社</th>
    	</tr>
    	<c:forEach var="book" items="${sessionScope.pageBean.data }">
    		<tr>
    			<td align="center"><img alt="书籍图片" src="../../${book.url }" onclick="gotoDetail(${book.id })" width="130px" height="180px" style="cursor: hand;"></td>
    			<td align="center"><a href="javascript:gotoDetail(${book.id })">${book.b_name }</a></td>
    			<td align="center">${book.out_price }</td>
    			<td align="center">${book.publish }</td>
    		</tr>
    	</c:forEach>
    </table>
    <form action="/SellBook_Team02/servlet/BookListServlet?type=${sessionScope.curtype }" method="post" id="myform">
    <div align="center">
    	第<font size="4" color="red">${sessionScope.pageBean.curPage }</font>页&nbsp;|&nbsp;
    	共<font size="4" color="red">${sessionScope.pageBean.totalPage }</font>页&nbsp;&nbsp;
    	<a href="javascript:first_page();" id="a1">首页</a>&nbsp;
    	<a href="javascript:pre_page();" id="a2">上一页</a>&nbsp;
    	<a href="javascript:next_page();" id="a3">下一页</a>&nbsp;
    	<a href="javascript:last_page();" id="a4">尾页</a>&nbsp;
    	每页<input type="text" name="pageSize" id="pageSize" size="1" value="${sessionScope.pageBean.pageSize }" onkeyup="validate_page()"/>条|
    	共<font color="red">${sessionScope.pageBean.totalRecord }</font>条&nbsp;
    	<input type="submit" value="go"/><input type="text" size="1" value="${sessionScope.pageBean.curPage }" name="curPage" id="curPage" onkeyup="validate_page()"/>页
    </div>
    </form>
    <br/> <br/><br/><br/><br/>
  </body>-->
  <!-- 马雪伦 -->
   <body background="../../images/bgcolor.png">
  <div id="top"><img src="../../images/base_logo.png" style="height: 62px; width: 64px; ">图书销售系统 
    <div align="right" id="top_right">
    	<font size="4" face="华文行楷" color="#FF8000">你好：${sessionScope.customer.c_name }</font>&nbsp;&nbsp;&nbsp;
    	<img  src="../../images/exit_logo.png" style="height: 25px; width: 27px; "><!-- 退出图标 -->
    	<a href="/SellBook_Team02/servlet/CustomerLogoutServlet"><font size="4" face="华文行楷" color="#5B5B5B">退出</font></a>
    </div>
   </div>
   <hr color="5B5B5B"/><br/><br/>
    <div align="center"><font size="4" face="华文行楷" color="#FF8000">${sessionScope.cus_update_info_success }</font></div>
    <%request.getSession().removeAttribute("cus_update_info_success"); %><!-- 移除提示 -->
    <div id="select" align="center">
    	<a href="/SellBook_Team02/servlet/BookListServlet?type=java"><font size="6px" face="楷体" color="#5B00AE">java</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<a href="/SellBook_Team02/servlet/BookListServlet?type=python"><font size="6px" face="楷体" color="#5B00AE">python</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	<a href="/SellBook_Team02/servlet/BookListServlet?type=c"><font size="6px" face="楷体" color="#5B00AE">c/c++</font></a>
   	</div>
   	<div id="set">
    	<img  src="../../images/shoppingcart_logo.png" style="height: 25px; width: 27px; ">
    	<a href="/SellBook_Team02/servlet/QuerySellOrderServlet"><font size="4" face="华文行楷" color="#0000E3">我的购物车</font></a><br/><br/>
    	<img  src="../../images/authcode_logo.png" style="height: 25px; width: 27px; ">
    	<a href="customer_update_info.jsp"><font size="4" face="华文行楷" color="#0000E3">修改信息</font></a>
     </div>
    <div id="deerl"><img src="../../images/img_deer.png" style="height: 250px; width: 250px; "></div>
    <div id="deerr"><img src="../../images/img_deer_r.jpg" style="height: 250px; width: 250px; "></div>
    <table align="center" bgcolor="#F0F0F0" border="1" bordercolor="#7B7B7B" cellpadding="0" cellspacing="0" width="60%"style="margin-top:1%;">
    	<tr style="height:40px;">
    		<th>图片</th>
    		<th>书名</th>
    		<th>价格(元)</th>
    		<th>出版社</th>
    	</tr>
    	<c:forEach var="book" items="${sessionScope.pageBean.data }">
    		<tr>
    			<td align="center"><img alt="书籍图片" src="../../${book.url }" onclick="gotoDetail(${book.id })" width="130px" height="180px" style="cursor: hand;"></td>
    			<td align="center"><a href="javascript:gotoDetail(${book.id })">${book.b_name }</a></td>
    			<td align="center">${book.out_price }</td>
    			<td align="center">${book.publish }</td>
    		</tr>
    	</c:forEach>
    </table><br/>
    <form action="/SellBook_Team02/servlet/BookListServlet?type=${sessionScope.curtype }" method="post" id="myform">
    <div align="center">
    	第<font size="4" color="red">${sessionScope.pageBean.curPage }</font>页&nbsp;|&nbsp;
    	共<font size="4" color="red">${sessionScope.pageBean.totalPage }</font>页&nbsp;&nbsp;
    	<a href="javascript:first_page();" id="a1">首页</a>&nbsp;
    	<a href="javascript:pre_page();" id="a2">上一页</a>&nbsp;
    	<a href="javascript:next_page();" id="a3">下一页</a>&nbsp;
    	<a href="javascript:last_page();" id="a4">尾页</a>&nbsp;
    	每页<input type="text" name="pageSize" id="pageSize" size="1" value="${sessionScope.pageBean.pageSize }" onkeyup="validate_page()"/>条|
    	共<font color="red" size="4">${sessionScope.pageBean.totalRecord }</font>条&nbsp;
    	<input type="submit" value="go"/><input type="text" size="1" value="${sessionScope.pageBean.curPage }" name="curPage" id="curPage" onkeyup="validate_page()"/>页
    </div>
    </form>
  </body>
</html>
