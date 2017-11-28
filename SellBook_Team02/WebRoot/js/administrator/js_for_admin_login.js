var issubmit = false;//false表示表单为提交
    function reSub(){
    	if(!issubmit){//防止表单重复提交
    		issubmit = true;
    		return true;
    	}
    	else
    		return false;
    	/**
    	$.ajax({
    		url:"",
    		dataType:"",
    		type:"",
    		success:function(data){
    			if(data==false){
    				issubmit = false;
    				$("#adminMsg").show().html("<font size='4' color='red'>登录失败！</font>");
    			}
    			else
    				issubmit = true;
    		},
    		error:function(){
    			alert("请求失败！");
    		}
    	});
    	*/
    }
    function changeImag(img){//点击验证码换一张
    	img.src = img.src + "?" + new Date().getTime();
    }