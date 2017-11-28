//文件加载时验证
window.onload = function(){
    if(curPage==1){
    	$("#a1").hide("fast");
    	$("#a2").hide("fast");
    }
    else{
    	$("#a1").show();
    	$("#a2").show();
    }
    if(curPage==totalPage){
    	$("#a3").hide("fast");
    	$("#a4").hide("fast");
    }
    else{
    	$("#a3").show();
    	$("#a4").show();
    }
}
//删除订单
function delOrder(order_id,book_name){
	if(confirm("确认要删除书名为'"+book_name+"'的订单吗？")){
		window.location.href = "/SellBook_Team02/servlet/SellOrderDelServlet?id="+order_id;
	}
}
//购买书籍结算
function updateOrderAndBook(order_id,amount,b_id,count){
		$.ajax({
			url:"/SellBook_Team02/servlet/QueryQuantityFromBookServlet?id="+b_id,
			dataType:"json",
			type:"post",
			data:{"bid":b_id},
			success:function(data1){
				if(count<=data1){
					if(confirm("书籍数量："+count+"    书籍总价：'"+amount+"'，确定要购买吗？")){
						window.location.href = "/SellBook_Team02/servlet/ByBookServlet?oid="+order_id;
					}
				}else{
					alert("库存中数量不足，请回主页重新选择购买");
				}
			},
			error:function(){
				alert("网络异常，请求失败！");
			}
		});
}
//点击首页
function first_page(){
	$("#curPage").val(1);
	$("#myform").submit();
}
//上一页
function pre_page(){
	$("#curPage").val(curPage-1);
	$("#myform").submit();
}
//下一页
function next_page(){
	$("#curPage").val(curPage+1);
	$("#myform").submit();
}
//尾页
function last_page(){
	$("#curPage").val(totalPage);
	$("#myform").submit();
}
//验证当前页和页面大小是否合法
function validate_page(){
	var pagesize = $("#pageSize").val();//获取文本框中的页面大小
	var curpage = $("#curPage").val();//获取文本框中的当前页面
	var regis = /^[1-9]\d*$/;
	//验证页面大小
	if(pagesize>totalRecord){//页面大小大于总记录数
		pagesize = totalRecord;
	}
	if((!regis.test(pagesize)) || pagesize<=0){//输入非法
		pagesize = pageSize;
	}
	$("#pageSize").val(pagesize);//将合法的页面大小显示给文本框
	//验证当前页
	if(curpage>totalPage){//当前页大于总页数
		curpage = totalPage;
	}
	if(curpage<=0 || (!regis.test(curpage))){
		curpage = curPage;
	}
	$("#curPage").val(curpage);//将合法的当前页显示给文本框
}
