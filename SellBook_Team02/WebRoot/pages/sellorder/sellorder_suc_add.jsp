<%@page import="com.hzit.entity.UnionOrderAndBook"%>
<%@ page import="com.hzit.util.pageutil.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车页面</title>
  <style type="text/css">
   #top{
 		width:98%;
  		position:relative;
  		left:2%;
  		font:55px '华文行楷';
  		color:#5B5B5B;
  	}
 tr{
 	font:18px '幼圆';
 } 		
  	#top_right{
  		margin-top:3%;
  		margin-right:2%;
  		float:right;
  	}
	
  </style>
    <script type="text/javascript" src="../../js/jquery-1.4.2.js"></script>
    <script type="text/javascript">
    	var curPage = ${sessionScope.order_pageBean.curPage };
    	var pageSize = ${sessionScope.order_pageBean.pageSize};
    	var totalPage = ${sessionScope.order_pageBean.totalPage};
    	var totalRecord = ${sessionScope.order_pageBean.totalRecord};
    </script>
    <script type="text/javascript" src="../../js/sellorder/js_for_sellorder_suc_add.js"></script>
  </head>
  <!-- <body>
  	<div align="right"><a href="/SellBook_Team02/servlet/BookListServlet">回到主页</a></div>
  	<div align="center"><font size="6" face="华文行楷" color="red">${sessionScope.orderisdel }</font></div>
  	<div align="center"><font size="6" face="华文行楷" color="red">${sessionScope.isby }</font></div>
  	<%
  		//request.getSession().removeAttribute("orderisdel");
  		//request.getSession().removeAttribute("isby");
  		//PageBean order_pageBean = (PageBean) request.getSession().getAttribute("order_pageBean");
  		//if(order_pageBean==null || order_pageBean.getTotalRecord()<=0){
  	 %>
  	<div align="center"><font size="6" face="华文行楷" color="red">暂无订单，快去添加吧！</font></div>
    <%
    //}else{
     %>
    <table align="center" width="80%" border="1">
    	<tr>
    	<th>图片</th>
    	<th>书名</th>
    	<th>数量</th>
    	<th>单价</th>
    	<th>总价</th>
    	<th>状态</th>
    	<th>操作</th>
    	</tr>
    	<c:forEach var="order" items="${sessionScope.order_pageBean.data }">
    	<tr>
    		<td align="center"><img alt="书籍图片" src="../../${order.url }" height="180px" width="130px"></td>
    		<td align="center">${order.b_name }</td>
    		<td align="center">${order.count }</td>
    		<td align="center">${order.out_price }</td>
    		<td align="center">${order.amount }</td>
    		<td align="center">${order.ispay==1?"已付款":"未付款" }</td>
    		<td align="center"><input type="button" id="del" name="del" value="删除" onclick="delOrder('${order.id}','${order.b_name }')"/>
	    		<c:if test="${order.ispay==0 }">
	    		<input type="button" value="购买" id="update" name="update" onclick="updateOrderAndBook('${order.id}','${order.amount }','${order.b_id }','${order.count }')"/>
	    		</c:if>
    		</td>
    	</tr>
    	</c:forEach>
    </table><br/><br/>
    <div align="center">
    <form action="/SellBook_Team02/servlet/QuerySellOrderServlet" method="post" id="myform">
    	第<font size="4" color="red">${sessionScope.order_pageBean.curPage }</font>页&nbsp;|&nbsp;
    	共<font size="4" color="red">${sessionScope.order_pageBean.totalPage }</font>页&nbsp;
    	<a href="javascript:first_page()" id="a1">首页</a>&nbsp;
    	<a href="javascript:pre_page()" id="a2">上一页</a>&nbsp;
    	<a href="javascript:next_page()" id="a3">下一页</a>&nbsp;
    	<a href="javascript:last_page()" id="a4">尾页</a>&nbsp;
    	每页<input type="text" id="pageSize" name="pageSize" value="${sessionScope.order_pageBean.pageSize }" size="1" onkeyup="validate_page()"/>条
    	共<font size="4" color="red">${sessionScope.order_pageBean.totalRecord }</font>条&nbsp;|&nbsp;
    	<input type="submit" size="1" value="go"/>
    	<input type="text" id="curPage" name="curPage" size="1" value="${sessionScope.order_pageBean.curPage }" onkeyup="validate_page()"/>页
    </form>
    </div>
    <%//} %>
  </body> -->
  <!-- 马雪伦 -->
  <body background="../../images/bgcolor.png">
  	<div id="top"><img src="../../images/book_logo.png" style="height: 65px; width: 65px; ">我的购物车
  		<div id="top_right">
  		<img  src="../../images/home_logo.png" style="height: 30px; width: 30px; ">
  		<a href="/SellBook_Team02/servlet/BookListServlet?type=${sessionScope.curtype }"><font size="5" face="华文行楷" color="#66B3FF">回到主页</font></a>
  		</div>
  	</div>
  	<br/><hr color="#5B5B5B"/>
  	<div align="center"><font size="6" face="华文行楷" color="red">${sessionScope.orderisdel }</font></div>
  	<div align="center"><font size="6" face="华文行楷" color="red">${sessionScope.isby }</font></div>
  	<%
  		request.getSession().removeAttribute("orderisdel");
  		request.getSession().removeAttribute("isby");
  		PageBean<UnionOrderAndBook> order_pageBean = (PageBean<UnionOrderAndBook>) request.getSession().getAttribute("order_pageBean");
  		if(order_pageBean==null || order_pageBean.getTotalRecord()<=0){
  	 %>
  	<div align="center"><font size="6" face="华文行楷" color="red">暂无订单，快去添加吧！</font></div>
    <%
    }else{
     %>
    <br/><br/>
    <table align="center"bgcolor="#F0F0F0" width="80%" border="1" cellpadding="0" cellspacing="0" bordercolor="#7B7B7B">
    	<tr style="height:40px;">
    	<th>图片</th>
    	<th>书名</th>
    	<th>数量</th>
    	<th>单价</th>
    	<th>总价</th>
    	<th>状态</th>
    	<th>操作</th>
    	</tr>
    	<c:forEach var="order" items="${sessionScope.order_pageBean.data }">
    	<tr>
    		<td align="center"><img alt="书籍图片" src="../../${order.url }" height="180px" width="130px"></td>
    		<td align="center">${order.b_name }</td>
    		<td align="center">${order.count }</td>
    		<td align="center">${order.out_price }</td>
    		<td align="center">${order.amount }</td>
    		<td align="center">${order.ispay==1?"已付款":"未付款" }</td>
    		<td align="center"><input type="button" id="del" name="del" value="删除" onclick="delOrder('${order.id}','${order.b_name }')"/>
	    		<c:if test="${order.ispay==0 }">
	    		<input type="button" value="购买" id="update" name="update" onclick="updateOrderAndBook('${order.id}','${order.amount }','${order.b_id }','${order.count }')"/>
	    		</c:if>
    		</td>
    	</tr>
    	</c:forEach>
    </table><br/><br/>
    <div align="center">
    <form action="/SellBook_Team02/servlet/QuerySellOrderServlet" method="post" id="myform">
    	第<font size="4" color="red">${sessionScope.order_pageBean.curPage }</font>页&nbsp;|&nbsp;
    	共<font size="4" color="red">${sessionScope.order_pageBean.totalPage }</font>页&nbsp;
    	<a href="javascript:first_page()" id="a1">首页</a>&nbsp;
    	<a href="javascript:pre_page()" id="a2">上一页</a>&nbsp;
    	<a href="javascript:next_page()" id="a3">下一页</a>&nbsp;
    	<a href="javascript:last_page()" id="a4">尾页</a>&nbsp;
    	每页<input type="text" id="pageSize" name="pageSize" value="${sessionScope.order_pageBean.pageSize }" size="1" onkeyup="validate_page()"/>条
    	共<font size="4" color="red">${sessionScope.order_pageBean.totalRecord }</font>条&nbsp;|&nbsp;
    	<input type="submit" size="1" value="go"/>
    	<input type="text" id="curPage" name="curPage" size="1" value="${sessionScope.order_pageBean.curPage }" onkeyup="validate_page()"/>页
    </form>
    </div>
    <%} %>
  </body>
</html>
