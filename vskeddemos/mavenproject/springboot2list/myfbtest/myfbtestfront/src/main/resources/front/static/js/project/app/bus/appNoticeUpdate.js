'use strict'

$(function(){
	$('#updateBt').on('click',appNoticeUpdate.update);
	webCommon.initICheck();
	appNoticeUpdate.initUI();
    $('#ntitle').focus();
});

var appNoticeUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appNoticeUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var ntitle=$('#ntitle').val();
		var ncontent=$('#ncontent').val();
		var state=$('input[name="state"]:checked').val();
		
		if(ntitle.length<2){
			toastr.error('标题不能为空');
			$('#ntitle').focus();
			return false;
		}
		if(ncontent.length<=0){
			toastr.error('内容不能为空');
			$('#ncontent').focus();
			return false;
		}
				
		var myBasePath='/webapi/v1/appnoticeupdate';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			ntitle: ntitle ,
			ncontent: ncontent ,
			state:state
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appNoticeUpdate.updateIsClick=false;
		setTimeout(function() {	appNoticeUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
	}
});