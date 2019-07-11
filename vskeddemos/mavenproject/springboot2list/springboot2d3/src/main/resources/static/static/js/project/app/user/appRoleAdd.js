'use strict'

$(function(){
	$('#addBt').on('click',appRoleAdd.add);
    $('#name').focus();
});

var appRoleAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appRoleAdd.addIsClick==false) return false;
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
		var myBasePath='/webapi/v1/approleadd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			name: name ,
			code: code 
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appRoleAdd.addIsClick=false;
		setTimeout(function() {	appRoleAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	}
});