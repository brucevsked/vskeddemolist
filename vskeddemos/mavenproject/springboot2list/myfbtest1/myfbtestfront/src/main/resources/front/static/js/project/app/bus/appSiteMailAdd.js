'use strict'

$(function(){
	$('#addBt').on('click',appSiteMailAdd.add);
    $('#smtitle').focus();
});

var appSiteMailAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appSiteMailAdd.addIsClick==false) return false;
		
		var smtitle=$('#smtitle').val();
		var smcontent=$('#smcontent').val();
		
		if(smtitle.length<2){
			toastr.error('标题不能为空');
			$('#smtitle').focus();
			return false;
		}
		if(smcontent.length<2){
			toastr.error('内容不能为空');
			$('#smcontent').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appsitemailadd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			smtitle: smtitle ,
			smcontent:smcontent
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');		
		appSiteMailAdd.addIsClick=false;
		setTimeout(function() {	appSiteMailAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	}
});