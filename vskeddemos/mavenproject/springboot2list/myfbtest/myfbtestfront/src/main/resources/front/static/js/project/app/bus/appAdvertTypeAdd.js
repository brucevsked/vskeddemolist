'use strict'

$(function(){
	$('#addBt').on('click',appAdvertTypeAdd.add);
    $('#advertTypeName').focus();
    webCommon.initICheck();
});

var appAdvertTypeAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appAdvertTypeAdd.addIsClick==false) return false;
		var advertTypeName=$('#advertTypeName').val();
		var description=$('#description').val();
		
		if(advertTypeName.length<=0){
			toastr.error('类型名称不能为空');
			$('#advertTypeName').focus();
			return false;
		}
		
		if(description.length<=0){
			toastr.error('类型描述不能为空');
			$('#description').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appadverttypeadd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			name: advertTypeName ,
			description: description ,
			parentid:-1
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appAdvertTypeAdd.addIsClick=false;
		setTimeout(function() {	appAdvertTypeAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	}
});