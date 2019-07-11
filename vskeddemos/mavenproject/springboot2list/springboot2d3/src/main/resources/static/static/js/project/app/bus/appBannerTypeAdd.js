'use strict'

$(function(){
	$('#addBt').on('click',appBannerTypeAdd.add);
    $('#tpname').focus();
    webCommon.initICheck();
});

var appBannerTypeAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appBannerTypeAdd.addIsClick==false) return false;
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
		
		var myBasePath='/webapi/v1/appbannertypeadd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			name: tpname ,
			description: description ,
			parentid:-1
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appBannerTypeAdd.addIsClick=false;
		setTimeout(function() {	appBannerTypeAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	}
});