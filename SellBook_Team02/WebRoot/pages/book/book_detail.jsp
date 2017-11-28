<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>书籍详情</title>
<style type="text/css">
body{
   		background-image:url(../../images/bgcolor.png);
   }
 #top{
  		position:relative;
  		top:20px;
  		font:70px '华文行楷';
  		color:#5B5B5B;
  	}
 tr{
 	font:18px '幼圆';
 }
#decrease{
	width:28px;
	height:28px;
	color:#7B7B7B;
	background-color: #D0D0D0;
	border:0px;
 	font-weight:bold;
 	border-radius:25%;
 	border-right:#BEBEBE 1px solid;
 	border-bottom:#BEBEBE 1px solid;
 	font-size:17px;
}
#increase{
	width:28px;
	height:28px;
	color:#7B7B7B;
	background-color: #D0D0D0;
	border:0px;
 	font-weight:bold;
 	border-radius:25%;
 	border-right:#BEBEBE 1px solid;
 	border-bottom:#BEBEBE 1px solid;
 	font-size:17px;
}
#shoppingcart{
	border-right:#BEBEBE 2px solid;
 	border-bottom:#BEBEBE 2px solid;
 	background-color:#D0D0D0;
 	width:100px;
 	height:30px;
 	font-size:13px;
 	color:#6C6C6C;
 	font-family: '幼圆';
 	font-weight:bold;
 	border-top-left-radius:35%;
 	border-bottom-right-radius:35%;
  
}
 #back{
 	border:0px;
 	background-color:transparent;
 	width:140px;
 	height:50px;
 	font-size:19px;
 	color:#8E8E8E;
 	font-family: '幼圆';
    font-weight:bold;
 }
</style>
<script type="text/javascript" src="../../js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	var quantityall = "${book.quantity }";//库存
	quantityall = parseInt(quantityall, 10);
</script>
<script type="text/javascript" src="../../js/book/js_for_book_detail.js"></script>
<script type="text/javascript">
	var type = "${sessionScope.curtype}";
	function gotoBookListServlet(){
		window.open("/SellBook_Team02/servlet/BookListServlet?type="+type, "_self");
	}
</script>
</head>
<!-- <body>
<div align="center"><font size="6" face="华文行楷" color="red">${sessionScope.add_sell_order_fail }</font></div>
<form action="/SellBook_Team02/servlet/AddSellOrderServlet" method="post" onsubmit="return issubmit()">
	<table align="center" style="margin-top: 200px;">
		<thead><tr><th colspan="4">书籍详情</th></tr></thead>
		<tbody>
			<tr>
				<th>图片</th>
				<th>书名</th>
				<th>价格(元)</th>
				<th>库存(本)</th>
				<th>出版社</th>
				<th>看中就下手</th>
			</tr>
			<tr>
				<td align="center"><img alt="书籍图片" src="../../${book.url }" width="200px" height="300px"></td>
				<td align="center">${book.b_name }</td>
				<td align="center">${book.out_price }</td>
				<td align="center">${book.quantity }</td>
				<td align="center">${book.publish }</td>
				<td align="center"><input type="button" value="-" size="1" onclick="subQuantity()"/>
				<input type="text" id="quantity" name="quantity" value="1" size="1" readonly="readonly"/>
				<input type="button" value="+" size="1" onclick="addQuantity()"/>
				<input type="submit" value="加入购物车"/></td>
			</tr>
			<tr><td align="center" colspan="6">
			<input type="button" value="返回" onclick="gotoBookListServlet()"/></td></tr>
		</tbody>
	</table>
	</form>
</body>-->
<!-- 马雪伦 -->
<body>
<div align="center"><font size="6" face="华文行楷" color="red">${sessionScope.add_sell_order_fail }</font></div>
<div id="top"><img src="../../images/book_logo.png" style="height: 90px; width: 90px; ">图书详情 </div>
<br/><hr size="2px" color="#5B5B5B"/>
<form action="/SellBook_Team02/servlet/AddSellOrderServlet" method="post" onSubmit="return issubmit()">
	<table  align="center" style="margin-top: 50px;" border="1" cellpadding="0" cellspacing="0" width="1000px;">
			<tr height="50px;">
				<th>图片</th>
				<th >书名</th>
				<th>价格(元)</th>
				<th>库存(本)</th>
				<th>出版社</th>
				<th>看中就下手</th>
			</tr>
			<tr>
				<td align="center"><img alt="书籍图片" src="../../${book.url }" width="200px" height="300px"></td>
				<td align="center">${book.b_name }</td>
				<td align="center">${book.out_price }</td>
				<td align="center">${book.quantity }</td>
				<td align="center">${book.publish }</td>
				<td align="center"><input type="button" value="-" id="decrease" size="1" onClick="subQuantity()"/>
				<input type="text" id="quantity" name="quantity" value="1" size="1" readonly="readonly"/>
				<input type="button" value="+" id="increase"size="1" onClick="addQuantity()"/>
				<input type="submit" value="加入购物车" id="shoppingcart"/></td>
			</tr>
	</table>	<br/>
	<div align="center"><input type="button" id="back" value="返 回" onClick="gotoBookListServlet()" onMouseOver="this.style.backgroundImage='url(../../images/back_logo.png)'" onMouseOut="this.style.backgroundImage=''"/></div>	

	</form>
</body>
</html>