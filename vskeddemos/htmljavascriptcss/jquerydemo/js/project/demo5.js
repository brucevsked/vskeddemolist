'use strict'


$(function(){
	$('#testBt').on('click',demo5.test1);
	$('#test1Bt').on('click',demo5.test2);
	$('#test2Bt').on('click',demo5.test3);
});


var demo5=new Object({
	test1:function(){
		var t1=$("#playTypeSel").find("option:selected").text(); //获取Select选择的text
		var v1=$("#playTypeSel").val(); //获取Select选择的Value
		console.log(t1+'|'+v1)
	},
	test2:function(){
		$("#playTypeSel").empty();//清空
		$("#playTypeSel").append("<option value='0'>顶级</option>");
		var dta1=[{'op':'1','va':'t1'},{'op':'2','va':'t2'},{'op':'2','va':'t3'}];
			$.each(dta1,function (myIndex,myEl){
				$("#playTypeSel").append('<option value="'+myEl.op+'">'+myEl.va+'</option>');
			});
	},
	test3:function(){
    var tya1r=$('input[name="tya1r"]:checked').val();
    console.log(tya1r);
	}
});