//点击“-”按钮
function subQuantity(){
	var quantity = parseInt($("#quantity").val(), 10);//10表示十进制
	if(quantity>1)
		quantity--;
	$("#quantity").val(quantity);
}
//点击“+”按钮
function addQuantity(){
	var quantity = parseInt($("#quantity").val(), 10);//10表示十进制
	if(quantity<quantityall)
		quantity++;
	$("#quantity").val(quantity);
}
//点击“加入购物车”按钮添加订单,防止表单重复提交
var able = true;//表单可以提交但未提交
function issubmit(){//防止表单重复提交
	if(able==true){
		able = false;
		return true;
	}else
		return false;
}