'use strict'

$(function(){
	$('#updateBt').on('click',appServerUpdate.update);
	webCommon.initICheck();
    $('#name').focus();
});

var appServerUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(appServerUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var group=$('#group').val();
		var ip='';
		var domain=$('#domain').val();
		var name=$('#name').val();
		var isp=$('#isp').val();
		var state=$('input[name="state"]:checked').val();
		
		if(name.length<=0){
			toastr.error('名称不能为空');
			$('#name').focus();
			return false;
		}
		if(group.length<=0){
			toastr.error('组名不能为空');
			$('#group').focus();
			return false;
		}

		if(domain.length<=0){
			toastr.error('域名不能为空');
			$('#domain').focus();
			return false;
		}
		if(isp.length<=0){
			toastr.error('运营商不能为空');
			$('#isp').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appserverupdate';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			group: group ,
			ip: ip ,
			domain: domain ,
			name: name ,
			isp: isp ,
			state: state ,
			areacode:0		
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appServerUpdate.updateIsClick=false;
		setTimeout(function() {	appServerUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	}
});