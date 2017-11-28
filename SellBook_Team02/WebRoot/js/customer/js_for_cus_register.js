var issubmit = [true,false,false,false,false];//false表示表单尚未提交,true表示表单不能被提交
//对用户名进行验证
function authC_name(){
	var c_name = $("#c_name").val();
	if(c_name!=null && c_name.indexOf(" ")>=0){
		issubmit[0] = true;
		$("#c_nameMsg").show().html("<font size='4' color='red'>用户名中不能有空字符！</font>");
	}
	else{
		$.ajax({
			url:"/SellBook_Team02/servlet/CustomerRegisterAuthServlet",
			data:{"c_name":c_name},
			dataType:"json",
			type:"post",
			success:function(data1){
				if(data1==true){
					issubmit[0] = false;
					$("#c_nameMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
				}
				else{
					issubmit[0] = true;
					$("#c_nameMsg").show().html("<font size='4' color='red'>用户名已存在！</font>");
				}
			},
			error:function(){
				alert("请求失败！");
			}
		});
	}
}
//验证密码长度是否符合标准
function authPassword(){
	var password = $("#password").val();
	if(password.length<6){
		issubmit[1] = true;
		$("#passwordMsg").show().html("<font size='4' color='red'>密码长度最低6位</font>");
	}else{
		issubmit[1] = false;
		$("#passwordMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
	}
}
//验证密码与确认密码是否相同
function authRepassword(){
	var password = $("#password").val();
	var repassword = $("#repassword").val();
	if(password!=repassword){
		issubmit[2] = true;
		$("#repasswordMsg").show().html("<font size='4' color='red'>确认密码与密码不同！</font>");
	}else{
		issubmit[2] = false;
		$("#repasswordMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
	}
}
//验证手机号
function authPhone(){
	var phone = $("#phone").val();
//	if(phone.length!=11){
//		issubmit[3] = true;
//		$("#phoneMsg").show().html("<font size='4' color='red'>手机号应为11位</font>");
//	}else{
//		issubmit[3] = false;
//		$("#phoneMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
//	}
	if(/^1\d{10}$/.test(phone)){
		issubmit[3] = false;
		$("#phoneMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
	}else{
		issubmit[3] = true;
		$("#phoneMsg").show().html("<font size='4' color='red'>以1开头的11位数字</font>");
	}
}
//点击验证码换一张
function changeImage(img){
	img.src = img.src+"?"+new Date().getTime();
}
//点击“去登录”超链接的响应事件
function toLogin(){
	window.location.href = "../../pages/customer/customer_login.jsp";
}
//判断验证码填写是否正确
function authAuthcode(){
	var code = $("#authcode").val().trim();
	if(code!=null && code!=""){
		$.ajax({
			url:"/SellBook_Team02/servlet/CustomerRegisterAuthCodeServlet",
			dataType:"json",
			type:"post",
			data:{"code":code},
			success:function(data1){
				if(data1==true){
					issubmit[4] = false;
					$("#authcodeMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
				}else{
					issubmit[4] = true;
					$("#authcodeMsg").show().html("<font size='4' color='red'>验证码错误</font>");
				}
			},
			error:function(){
				alert("请求失败！");
			}
		});
	}
//	var authcode = "<%=Session['authcode']%>";
//	alert("authcode="+authcode);
//	var code = $("#authcode").val();
//	if(authcode==code){
//		issubmit[4] = false;
//		$("#authcodeMsg").show().html("<img src='../../images/img19.png' width='15' height='15'/>");
//	}
//	else{
//		issubmit[4] = true;
//		$("#authcodeMsg").show().html("<font size='4' color='red'>验证码错误</font>");
//	}
}
//
function toLogin(){
	window.open("../../pages/customer/customer_login.jsp", "_self");
}
//防止表单重复提交
function authSubmit(){
	for(var i=0;i<issubmit.length;++i){
		if(issubmit[i]==true)
			return false;
	}
	issubmit[0] = true;
	return true;
}