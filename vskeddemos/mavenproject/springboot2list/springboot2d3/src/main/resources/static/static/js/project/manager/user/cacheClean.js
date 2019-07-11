'use strict'

$(function(){
	$('#updateBt').on('click',cacheClean.update);
	cacheClean.initUI();
});

var cacheClean=new Object({
	updateIsClick:true,
	update:function(){
		if(cacheClean.updateIsClick==false) return false;
		
		var cachetype=$('#cachetype').val();
		
		if(cachetype.length<=0){
			toastr.error('缓存类型不能为空');
			return false;
		}
		
		var myBasePath='/webapi/v1/appcacheclean';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			cachetype:cachetype			
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		cacheClean.updateIsClick=false;
		setTimeout(function() {	cacheClean.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	},
	initUI:function(){
		$('#cachetype').select2({width: '100%'});
	}
});