'use strict'

$(function(){
	$('#updateBt').on('click',appSiteMailUpdate.update);
	webCommon.initICheck();
	appSiteMailUpdate.initUI();
    $('#smtitle').focus();
});

var appSiteMailUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appSiteMailUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var smtitle=$('#smtitle').val();
		var smcontent=$('#smcontent').val();
		var state=$('input[name="state"]:checked').val();
		
		if(smtitle.length<2){
			toastr.error('标题不能为空');
			$('#smtitle').focus();
			return false;
		}
		if(smcontent.length<=0){
			toastr.error('内容不能为空');
			$('#smcontent').focus();
			return false;
		}
				
		var myBasePath='/webapi/v1/appsitemailupdate';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			smtitle: smtitle ,
			smcontent: smcontent ,
			state:state
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appSiteMailUpdate.updateIsClick=false;
		setTimeout(function() {	appSiteMailUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
	}
});