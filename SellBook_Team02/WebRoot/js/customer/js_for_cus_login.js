var auth = false;
var issubmit = false;//表示表单尚未提交
function authAuthcode(){//登录时判断验证码输入是否正确
	var code = $("#authcode").val().trim();
	if(code!=null && code!=""){
		$.ajax({
			url:"/SellBook_Team02/servlet/CustomerRegisterAuthCodeServlet",
			dataType:"json",
			type:"post",
			data:{"code":code},
			success:function(data1){
				if(data1==true){
					auth = true;
					$("#cusMsg").show().html("<font> </font>");
				}else{
					auth = false;
					$("#cusMsg").show().html("<font size='4' color='red'>验证码错误</font>");
				}
			},
			error:function(){
				alert("请求失败！");
			}
		});
	}
}
function changeImag(img){//点击图片换一张
	img.src = img.src + "?" + new Date().getTime();
}
function login(){//防止表单重复提交
	if(auth==false)
		return false;
	else{
		if(issubmit==false){
			issubmit = true;
			return true;
		}else
			return false;
	}
}