'use strict'

$(function(){
	$('#updateBt').on('click',appUserBalanceUpdate.update);
    webCommon.initICheck();
    $('#amount').focus();
});

var appUserBalanceUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appUserBalanceUpdate.updateIsClick==false) return false;
		var fuid=$('#fuid').val();
		var amount=$('#amount').val();
		var feetype=$('input[name="feetype"]:checked').val();
		var myBasePath='/webapi/v1/appuserbalanceupdate';
		
		if(amount.length<=0){
			toastr.error('金额不能为空');
			$('#amount').focus();
			return false;
		}
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fuid: fuid ,
			amount: amount ,
			feetype:feetype
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appUserBalanceUpdate.updateIsClick=false;
		setTimeout(function() {	appUserBalanceUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	}
});