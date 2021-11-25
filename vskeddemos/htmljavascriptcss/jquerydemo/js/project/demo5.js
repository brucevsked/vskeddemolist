"use strict"


$(function(){
	$("#testBt").on("click",demo5.test1);
	$("#test1Bt").on("click",demo5.test2);
	$("#test2Bt").on("click",demo5.test3);
	$("#test3Bt").on("click",demo5.test4);
});


var demo5=new Object({
	test1:function(){
		var t1=$("#playTypeSel").find("option:selected").text(); //获取Select选择的text
		var v1=$("#playTypeSel").val(); //获取Select选择的Value
		console.log(t1+"|"+v1);
		alert("选中的值是："+v1+"|选中的文本是:"+t1);
	},
	test2:function(){
		$("#playTypeSel").empty();//清空
		$("#playTypeSel").append("<option value='0'>顶级</option>");
		var dta1=[{"op":"1","va":"新玩法类型1"},{"op":"2","va":"新玩法类型2"},{"op":"2","va":"新玩法类型3"}];
			$.each(dta1,function (myIndex,myEl){
				$("#playTypeSel").append("<option value='"+myEl.op+"'>"+myEl.va+"</option>");
			});
	},
	test3:function(){
    var tya1r=$("input[name='tya1r']:checked").val();
    console.log(tya1r);
	$("#playTypeSel").val(tya1r);
	},
	test4:function(){
      //清空值为非1的元素并重新添加
	  var optionArray=$("#playTypeSel option");
	  $.each(optionArray,function (myIndex,myEl){
		console.log("|"+myIndex+"|"+myEl+"|"+myEl.value+"|"+myEl.text);
		var curValue=myEl.value;
		if(curValue!=1){
			this.remove(); //移除方案1
			//$("#playTypeSel option[value='"+curValue+"']").remove();//移除方案2 不推荐
		}

		});

		$("#playTypeSel").append("<option value='0'></option>");
		var dta1=[{"op":"7","va":"我是谁"},{"op":"8","va":"这是哪儿"},{"op":"9","va":"现在什么年代你还看网站"}];
			$.each(dta1,function (myIndex,myEl){
				$("#playTypeSel").append("<option value='"+myEl.op+"'>"+myEl.va+"</option>");
			});
	}

});