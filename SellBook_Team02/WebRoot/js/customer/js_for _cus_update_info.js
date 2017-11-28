var arr = [false,false,false,true];
//验证旧密码是否正确
function authOldPassword(pwd){
	var password = $("#oldpwd").val();
	if(pwd==password){
		arr[0] = true;
		$("#oldpwdMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
	}else{
		arr[0] = false;
		$("#oldpwdMsg").show().html("<font size='4' color='red'>密码错误</font>");
	}
}
//验证新密码是否符合要求
function authNewPassword(){
	var password = $("#newpwd").val();
	if(password.length>=6){
		arr[1] = true;
		$("#newpwdMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
	}else{
		arr[1] = false;
		$("#newpwdMsg").show().html("<font size='4' color='red'>密码最少6位</font>");
	}
}
//验证确认密码与新密码是否一样
function authReNewPassword(){
	var password = $("#newpwd").val();
	var repassword = $("#renewpwd").val();
	if(password==repassword){
		arr[2] = true;
		$("#repwdMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
	}else{
		arr[2] = false;
		$("#repwdMsg").show().html("<font size='4' color='red'>确认密码与新密码不相同</font>");
	}
}
//验证手机号是否合法
function authPhone(){
	var regs = /^1\d{10}$/;
	var phone = $("#phone").val();
	if(regs.test(phone)){
		arr[3] = true;
		$("#phoneMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
	}else{
		arr[3] = false;
		$("#phoneMsg").show().html("<font size='4' color='red'>手机号是以1开头的11位数字</font>");
	}
}
//按返回键请求BookListServlet
function gotoBookListServlet(type){
	window.open("/SellBook_Team02/servlet/BookListServlet?type="+type, "_self");
}
//输入不合法是点击修改按钮无效，以及防止表单重复提交
function issubmit(){
	for(var i=0;i<arr.length;++i){
		if(arr[i]==false)
			return false;
	}
	arr[0] = false;
	return true;
}