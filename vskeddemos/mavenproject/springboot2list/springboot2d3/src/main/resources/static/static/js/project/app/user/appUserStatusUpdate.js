'use strict'

$(function(){
	$('#updateBt').on('click',appUserStatusUpdate.update);
    webCommon.initICheck();
});

var appUserStatusUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appUserStatusUpdate.updateIsClick==false) return false;
		var status=$('input[name="status"]:checked').val();
		var fuid=$('#fuid').val();
		var myBasePath='/webapi/v1/appuserstatusupdate';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fuid: fuid ,
			status:status
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appUserStatusUpdate.updateIsClick=false;
		setTimeout(function() {	appUserStatusUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	}
});