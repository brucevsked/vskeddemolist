'use strict'

$(function(){
	$('#updateBt').on('click',appUserCashReView.update);
    webCommon.initICheck();
    appUserCashReView.initUI();
});

var appUserCashReView=new Object({
	updateIsClick:true,
	update:function(){
		if(appUserCashReView.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var fuid=$('#fuid').val();
		var opaccount1=$('#opaccount').val();
		var cashstate=$('input[name="cashstate"]:checked').val();
		var myBasePath='/webapi/v1/appusercashreview';
		
		if(cashstate==1){
			if(opaccount1.length<5){
				toastr.error('请输入正确打款账号！');
				$('#opaccount').focus();
				return false;
			}
		}

		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid: fid ,
			fuid: fuid ,
			opaccount: opaccount1 ,
			cashstate:cashstate
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appUserCashReView.updateIsClick=false;
		setTimeout(function() {	appUserCashReView.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
		$('#myAccountDiv').hide();
		$('input[name="cashstate"]').on('ifChecked', function(event){
			  var obj=$(this);
			  if(obj.val()==1){
				  $('#myAccountDiv').show();
				  $('#opaccount').focus();
			  }else{
				  $('#myAccountDiv').hide();
			  }
		});
	}
});