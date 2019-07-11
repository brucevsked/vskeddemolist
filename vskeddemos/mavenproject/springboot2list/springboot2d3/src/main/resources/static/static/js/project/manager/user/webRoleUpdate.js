'use strict'

$(function(){
	$('#updateBt').on('click',webRoleUpdate.update);
    $('#name').focus();
});

var webRoleUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(webRoleUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var name=$('#name').val();
		var code=$('#code').val();
		
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
		
		var myBasePath='/webapi/v1/webroleupdate';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			name: name ,
			code: code
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		webRoleUpdate.updateIsClick=false;
		setTimeout(function() {	webRoleUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	}
});