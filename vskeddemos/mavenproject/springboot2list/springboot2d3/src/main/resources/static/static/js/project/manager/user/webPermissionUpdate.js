'use strict'

$(function(){
	$('#updateBt').on('click',webPermissionUpdate.update);
    $('#name').focus();
});

var webPermissionUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(webPermissionUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var name=$('#name').val();
		var code=$('#code').val();
		var uri=$('#uri').val();
		
		if(name.length<=0){
			toastr.error('名称不能为空');
			$('#name').focus();
			return false;
		}
		if(code.length<=0){
			toastr.error('编码不能为空');
			$('#code').focus();
			return false;
		}
		if(uri.length<=0){
			toastr.error('uri不能为空');
			$('#uri').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/webpermissionupdate';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			name: name ,
			code: code ,
			uri:uri				
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		webPermissionUpdate.updateIsClick=false;
		setTimeout(function() {	webPermissionUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	}
});