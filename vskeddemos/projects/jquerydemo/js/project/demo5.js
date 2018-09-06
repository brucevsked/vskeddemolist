'use strict'


$(function(){
	$('#testBt').on('click',demo5.test1);
});


var demo5=new Object({
	test1:function(){
		var t1=$("#playTypeSel").find("option:selected").text(); //获取Select选择的text
		var v1=$("#playTypeSel").val(); //获取Select选择的Value
		console.log(t1+'|'+v1)
	}
});