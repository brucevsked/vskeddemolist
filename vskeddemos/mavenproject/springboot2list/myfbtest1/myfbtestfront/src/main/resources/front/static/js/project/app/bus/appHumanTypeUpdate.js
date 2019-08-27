'use strict'

$(function(){
	$('#updateBt').on('click',appHumanTypeUpdate.update);
    webCommon.initICheck();
    appHumanTypeUpdate.initUI();
    $('#htname').focus();
});

var appHumanTypeUpdate=new Object({
	updateIsClick:true,
	oldSelectedOption:null,
	update:function(){
		if(appHumanTypeUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var htname=$('#htname').val();
		var htdescription=$('#htdescription').val();
		
		if(htname.length<2){
			toastr.error('类型名称不能为空');
			$('#htname').focus();
			return false;
		}
		if(htdescription.length<2){
			toastr.error('类型描述不能为空');
			$('#htdescription').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/apphumantypeupdate';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			name: htname ,
			description: htdescription ,
			parentid: -1 ,
			level:0
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appHumanTypeUpdate.updateIsClick=false;
		setTimeout(function() {	appHumanTypeUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	},
	initUI:function(){
	}
});