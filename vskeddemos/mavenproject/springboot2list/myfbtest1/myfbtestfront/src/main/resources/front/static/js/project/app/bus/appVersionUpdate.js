'use strict'

$(function(){
	$('#updateBt').on('click',appVersionUpdate.update);
	webCommon.initICheck();
	appVersionUpdate.initUI();
    $('#ntitle').focus();
});

var appVersionUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appVersionUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var devicetype=$('input[name="devicetype"]:checked').val();
		var state=$('input[name="state"]:checked').val();
		var name=$('#name').val();
		var code=$('#code').val();
		var upcontent=$('#upcontent').val();
		var version=$('#version').val();
		var versionidentify=$('#versionidentify').val();
		var serverversion=$('#serverversion').val();
		var updateurl=$('#updateurl').val();
		
		if(name.length<2){
			toastr.error('版本名称不能为空');
			$('#name').focus();
			return false;
		}
		if(code.length<1){
			toastr.error('版本代码不能为空');
			$('#code').focus();
			return false;
		}
		
		if(upcontent.length<2){
			toastr.error('更新内容不能为空');
			$('#upcontent').focus();
			return false;
		}
		
		if(version.length<1){
			toastr.error('版本号不能为空');
			$('#version').focus();
			return false;
		}
		if(versionidentify.length<2){
			toastr.error('版本唯一标识不能为空');
			$('#versionidentify').focus();
			return false;
		}
		
		if(serverversion.length<2){
			toastr.error('服务端api版本不能为空');
			$('#serverversion').focus();
			return false;
		}
		
		if(updateurl.length<2){
			toastr.error('版本更新地址不能为空');
			$('#updateurl').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appversionupdate';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			devicetype: devicetype ,
			state:state,
			name: name ,
			code: code ,
			upcontent: upcontent ,
			version: version ,
			serverversion: serverversion ,
			versionidentify: versionidentify ,
			updateurl:updateurl
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');	
		
		appVersionUpdate.updateIsClick=false;
		setTimeout(function() {	appVersionUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
	}
});