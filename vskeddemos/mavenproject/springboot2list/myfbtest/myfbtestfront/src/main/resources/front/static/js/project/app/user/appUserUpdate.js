'use strict'

$(function(){
	$('#updateBt').on('click',appUserUpdate.update);
	webCommon.initICheck();
});

var appUserUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appUserUpdate.updateIsClick==false) return false;
		var fuid=$('#fuid').val();
		var phone=$('#phone').val();
		var myinvitationcode=$('#myinvitationcode').val();
		var isagent=$('input[name="isagent"]:checked').val();
		var status=$('input[name="status"]:checked').val();
		var myBasePath='/webapi/v1/appuserupdate';
		
		if(phone.length<=0){
			toastr.error('手机号不能为空');
			$('#phone').focus();
			return false;
		}
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fuid: fuid ,
			phone: phone ,
			myinvitationcode: myinvitationcode ,
			isagent: isagent ,
			status:status
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appUserUpdate.updateIsClick=false;
		setTimeout(function() {	appUserUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	}
});