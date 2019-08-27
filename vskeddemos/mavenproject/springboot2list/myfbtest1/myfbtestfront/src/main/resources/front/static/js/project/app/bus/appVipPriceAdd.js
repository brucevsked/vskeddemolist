'use strict'

$(function(){
	$('#addBt').on('click',appVipPriceAdd.add);
    appVipPriceAdd.initUI();
    $('#vpname').focus();
});

var appVipPriceAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appVipPriceAdd.addIsClick==false) return false;
		
		var vpname=$('#vpname').val();
		var vpdays=$('#vpdays').val();
		var vpprice=$('#vpprice').val();
		
		if(vpname.length<2){
			toastr.error('名称不能为空');
			$('#vpname').focus();
			return false;
		}
		if(vpdays.length<=0){
			toastr.error('天数不能为空');
			$('#vpdays').focus();
			return false;
		}
		if(vpprice.length<=0){
			toastr.error('价格不能为空');
			$('#vpprice').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appvippriceadd';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			name: vpname ,
			level: 1 ,
			days: vpdays ,
			price:vpprice
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appVipPriceAdd.addIsClick=false;
		setTimeout(function() {	appVipPriceAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
	}
});