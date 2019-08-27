'use strict'

$(function(){
	$('#updateBt').on('click',appAdvertTypeUpdate.update);
    $('#advertTypeName').focus();
});

var appAdvertTypeUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appAdvertTypeUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var advertTypeName=$('#advertTypeName').val();
		var description=$('#description').val();
		
		if(advertTypeName.length<=0){
			toastr.error('类型名称不能为空');
			$('#advertTypeName').focus();
			return false;
		}
		
		if(description.length<=0){
			toastr.error('类型描述不能为空');
			$('#description').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appadverttypeupdate';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			name: advertTypeName ,
			description:description,
			parentid:-1				
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appAdvertTypeUpdate.updateIsClick=false;
		setTimeout(function() {	appAdvertTypeUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	}
});