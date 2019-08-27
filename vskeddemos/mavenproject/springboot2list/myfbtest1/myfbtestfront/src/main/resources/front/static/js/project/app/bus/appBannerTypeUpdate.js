'use strict'

$(function(){
	$('#updateBt').on('click',appBannerTypeUpdate.update);
    $('#tpname').focus();
});

var appBannerTypeUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appBannerTypeUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var tpname=$('#tpname').val();
		var description=$('#description').val();
		
		if(tpname.length<=0){
			toastr.error('类型名称不能为空');
			$('#tpname').focus();
			return false;
		}
		
		if(description.length<=0){
			toastr.error('类型描述不能为空');
			$('#description').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appbannertypeupdate';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			name: tpname ,
			description:description,
			parentid:-1				
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appBannerTypeUpdate.updateIsClick=false;
		setTimeout(function() {	appBannerTypeUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	}
});