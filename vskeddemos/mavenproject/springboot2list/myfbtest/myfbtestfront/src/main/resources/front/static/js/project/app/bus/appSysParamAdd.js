'use strict'

$(function(){
	$('#addBt').on('click',appSysParamAdd.add);
    $('#sysparamtype').focus();
    webCommon.initICheck();
});

var appSysParamAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appSysParamAdd.addIsClick==false) return false;
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
		
		var myBasePath='/webapi/v1/appsysparamadd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
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
		
		appSysParamAdd.addIsClick=false;
		setTimeout(function() {	appSysParamAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	}
});