'use strict'

$(function(){
	$('#addBt').on('click',appNoticeAdd.add);
    $('#ntitle').focus();
});

var appNoticeAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appNoticeAdd.addIsClick==false) return false;
		
		var ntitle=$('#ntitle').val();
		var ncontent=$('#ncontent').val();
		
		if(ntitle.length<2){
			toastr.error('标题不能为空');
			$('#ntitle').focus();
			return false;
		}
		if(ncontent.length<2){
			toastr.error('内容不能为空');
			$('#ncontent').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appnoticeadd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			ntitle: ntitle ,
			ncontent:ncontent
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');		
		appNoticeAdd.addIsClick=false;
		setTimeout(function() {	appNoticeAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	}
});