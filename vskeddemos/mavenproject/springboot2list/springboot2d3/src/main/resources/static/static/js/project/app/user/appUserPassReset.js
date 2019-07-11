'use strict'

$(function(){
	$('#updateBt').on('click',appUserPassReset.update);
    $('#userpass').focus();
});

var appUserPassReset=new Object({
	updateIsClick:true,
	update:function(){
		if(appUserPassReset.updateIsClick==false) return false;
		var fuid=$('#fuid').val();
		var userpass=$('#userpass').val();
		
		if(userpass.length<=0){
			toastr.error('重置密码不能为空');
			$('#userpass').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appuserpassreset';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fuid:fuid,
			userpass:userpass			
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appUserPassReset.updateIsClick=false;
		setTimeout(function() {	appUserPassReset.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	}
});