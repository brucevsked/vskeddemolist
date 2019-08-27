'use strict'

$(function(){
	$('#updateBt').on('click',appSysParamUpdate.update);
    $('#sysparamtype').focus();
});

var appSysParamUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appSysParamUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var sysparamtype=$('#sysparamtype').val();
		var sysparamcode=$('#sysparamcode').val();
		var sysparamname=$('#sysparamname').val();
		var sysparamvalue=$('#sysparamvalue').val();
		
		if(sysparamtype.length<=0){
			toastr.error('参数类型不能为空');
			$('#sysparamtype').focus();
			return false;
		}
		
		if(sysparamcode.length<=0){
			toastr.error('参数编码不能为空');
			$('#sysparamcode').focus();
			return false;
		}
		
		if(sysparamname.length<=0){
			toastr.error('参数名称不能为空');
			$('#sysparamname').focus();
			return false;
		}
		
		if(sysparamvalue.length<=0){
			toastr.error('参数值不能为空');
			$('#sysparamvalue').focus();
			return false;
		}
		
		
		var myBasePath='/webapi/v1/appsysparamupdate';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			sysparamtype: sysparamtype ,
			sysparamcode: sysparamcode ,
			sysparamname: sysparamname ,
			sysparamvalue:sysparamvalue			
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appSysParamUpdate.updateIsClick=false;
		setTimeout(function() {	appSysParamUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	}
});