'use strict'

$(function(){
	$('#addBt').on('click',webPermissionAdd.add);
    $('#name').focus();
});

var webPermissionAdd=new Object({
	addIsClick:true,
	add:function(){
		if(webPermissionAdd.addIsClick==false) return false;
		var name=$('#name').val();
		var code=$('#code').val();
		var uri=$('#uri').val();
		
		if(name.length<=0){
			toastr.error('名称不能为空');
			$('#name').focus();
			return false;
		}
		if(code.length<=0){
			toastr.error('编码不能为空');
			$('#code').focus();
			return false;
		}
		if(uri.length<=0){
			toastr.error('uri不能为空');
			$('#uri').focus();
			return false;
		}
		var myBasePath='/webapi/v1/webpermissionadd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			name: name ,
			code: code ,
			uri:uri
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		webPermissionAdd.addIsClick=false;
		setTimeout(function() {	webPermissionAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	}
});