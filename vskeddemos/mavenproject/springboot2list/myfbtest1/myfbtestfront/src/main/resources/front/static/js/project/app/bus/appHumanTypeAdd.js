'use strict'

$(function(){
	$('#addBt').on('click',appHumanTypeAdd.add);
    webCommon.initICheck();
    appHumanTypeAdd.initUI();
    $('#htname').focus();
});

var appHumanTypeAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appHumanTypeAdd.addIsClick==false) return false;
		var htname=$('#htname').val();
		var htdescription=$('#htdescription').val();
		
		if(htname.length<2){
			toastr.error('类型名称不能为空');
			$('#htname').focus();
			return false;
		}
		if(htdescription.length<2){
			toastr.error('类型描述不能为空');
			$('#htdescription').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/apphumantypeadd';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			name: htname ,
			description: htdescription ,
			parentid: -1 ,
			level:0
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appHumanTypeAdd.addIsClick=false;
		setTimeout(function() {	appHumanTypeAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
	}
});