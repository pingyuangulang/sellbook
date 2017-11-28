<%@page import="com.hzit.entity.AdminOrder"%>
<%@page import="com.hzit.util.pageutil.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员主页</title>
    <script type="text/javascript" src="../../js/jquery-1.4.2.js"></script>
    <script type="text/javascript">
    	var curPage = ${adminorder_pageBean.curPage };
    	var pageSize = ${adminorder_pageBean.pageSize };
    	var totalPage = ${adminorder_pageBean.totalPage };
    	var totalRecord = ${adminorder_pageBean.totalRecord };
    </script>
    <script type="text/javascript" src="../../js/administrator/js_for_admin_success_login.js"></script>
  <style type="text/css">
  body{
  	background-image: url("../../images/bgcolor.png");
  }
  </style>
  </head>
  
  <body>
  <div align="right">
  <img  src="../../images/exit_logo.png" style="height: 25px; width: 27px; "><!-- 退出图标 -->
  <a href="/SellBook_Team02/servlet/AdminLogoutServlet"><font size="4" face="华文行楷" color="#5B5B5B">退出</font></a>
  </div>
  <div align="center"><font size="4" face="华文行楷" color="red">${sessionScope.delMsg } ${sessionScope.updateMsg }</font></div>
  <%request.getSession().removeAttribute("delMsg");//删除提示信息
  	request.getSession().removeAttribute("updateMsg");//修改提示信息
  %>
   <div align="center" style="margin-right: 30px;">
   <%
   		PageBean<AdminOrder> adminorder_pageBean = (PageBean<AdminOrder>)request.getSession().getAttribute("adminorder_pageBean");
   		int totalRecord = adminorder_pageBean.getTotalRecord();
   		if(totalRecord<=0){
    %>
    		<font size="6" face="华文行楷" color="red">暂无此类订单，需要提高人气哦</font>
    <div align="center">
    <a href="/SellBook_Team02/servlet/AdminOrderListServlet?isdeal=2"><font size="6px" face="华文行楷" color="#5B00AE">全部订单</font></a>
    <a href="/SellBook_Team02/servlet/AdminOrderListServlet?isdeal=1"><font size="6px" face="华文行楷" color="#5B00AE">已处理</font></a>
    <a href="/SellBook_Team02/servlet/AdminOrderListServlet?isdeal=0"><font size="6px" face="华文行楷" color="#5B00AE">未处理</font></a>
    </div><br/><br/>
    <%}else{ %>
    <div align="center">
    <a href="/SellBook_Team02/servlet/AdminOrderListServlet?isdeal=2"><font size="6px" face="华文行楷" color="#5B00AE">全部订单</font></a>
    <a href="/SellBook_Team02/servlet/AdminOrderListServlet?isdeal=1"><font size="6px" face="华文行楷" color="#5B00AE">已处理</font></a>
    <a href="/SellBook_Team02/servlet/AdminOrderListServlet?isdeal=0"><font size="6px" face="华文行楷" color="#5B00AE">未处理</font></a>
    </div><br/><br/>
   	<table border="1" width="1100px;">
   		<tr align="center" height="40px;">
   		<th>书籍图片</th>
   		<th>书籍名称</th>
   		<th>购买数量</th>
   		<th>书籍总价</th>
   		<th>客户姓名</th>
   		<th>客户电话</th>
   		<th>客户地址</th>
   		<th>处理状态</th>
   		<th>可行操作</th>
   		</tr>
   		<c:forEach var="adminorder" items="${sessionScope.adminorder_pageBean.data }">
	   		<tr align="center">
		   		<td><img alt="书籍图片" src="../../${adminorder.b_url }" height="180px" width="130px"></td>
		   		<td>${adminorder.b_name }</td>
		   		<td>${adminorder.count }</td>
		   		<td>${adminorder.amount }</td>
		   		<td>${adminorder.c_name }</td>
		   		<td>${adminorder.c_phone }</td>
		   		<td>${adminorder.c_address }</td>
		   		<td>${adminorder.isdeal==1?"已处理":"未处理" }</td>
		   		<td><input type="button" value="删除" onclick="delAdminOrder('${adminorder.id }','${adminorder.b_name }')"/>
		   		<c:if test="${adminorder.isdeal==0 }">
		   		<input type="button" value="处理" onclick="updateAdminOrder('${adminorder.id }','${adminorder.b_name }')"/>
		   		</c:if></td>
	   		</tr>
   		</c:forEach>
   	</table><br/><br/>
   	<div align="center">
    <form action="/SellBook_Team02/servlet/AdminOrderListServlet?isdeal=${sessionScope.isdeal }" method="post" id="myform">
    	第<font size="4" color="red">${sessionScope.adminorder_pageBean.curPage }</font>页&nbsp;|&nbsp;
    	共<font size="4" color="red">${sessionScope.adminorder_pageBean.totalPage }</font>页&nbsp;
    	<a href="javascript:first_page()" id="a1">首页</a>&nbsp;
    	<a href="javascript:pre_page()" id="a2">上一页</a>&nbsp;
    	<a href="javascript:next_page()" id="a3">下一页</a>&nbsp;
    	<a href="javascript:last_page()" id="a4">尾页</a>&nbsp;
    	每页<input type="text" id="pageSize" name="pageSize" value="${sessionScope.adminorder_pageBean.pageSize }" size="1" onkeyup="validate_page()"/>条
    	共<font size="4" color="red">${sessionScope.adminorder_pageBean.totalRecord }</font>条&nbsp;|&nbsp;
    	<input type="submit" size="1" value="go"/>
    	<input type="text" id="curPage" name="curPage" size="1" value="${sessionScope.adminorder_pageBean.curPage }" onkeyup="validate_page()"/>页
    </form>
    </div>
   	<%} %>
   </div>
  </body>
</html>
