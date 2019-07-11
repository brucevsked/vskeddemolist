'use strict'

$(function(){
	$('#updateBt').on('click',appVipPriceUpdate.update);
	appVipPriceUpdate.initUI();
    $('#vpname').focus();
});

var appVipPriceUpdate=new Object({
	updateIsClick:true,
	oldSelectedOption:null,
	update:function(){
		if(appVipPriceUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
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
		
		var myBasePath='/webapi/v1/appvippriceupdate';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
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
		
		appVipPriceUpdate.updateIsClick=false;
		setTimeout(function() {	appVipPriceUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
	}
});