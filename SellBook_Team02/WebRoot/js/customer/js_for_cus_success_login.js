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
//点击图片或书名查看详情
function gotoDetail(id){
	window.open("/SellBook_Team02/servlet/BookDetailServlet?id="+id, "_self");
}
//验证文本框中的数据
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
//分页中的首页
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