'use strict'

$(function(){
	$('#addBt').on('click',appCardCodeAdd.add);
	appCardCodeAdd.initUI();
    $('#count').focus();
});

var appCardCodeAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appCardCodeAdd.addIsClick==false) return false;
		
		var vippriceid=$('#vippriceid').select2('val');
		var fid=$('#fid').val();
		var count=$('#count').val();
		var expire=$('#expire').val();
		

		if(count.length<=0){
			toastr.error('数量不能为空');
			$('#count').focus();
			return false;
		}
		if(expire.length<=0){
			toastr.error('过期时间不能为空');
			$('#expire').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appcardcodeadd';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid: fid ,
			vippriceid: vippriceid ,
			count:count ,
			expire:expire
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appCardCodeAdd.addIsClick=false;
		setTimeout(function() {	appCardCodeAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
		$.post('/webapi/v1/appvippricelist1',{token:$('#servertoken').val()},function (dt){
			var tmpArray=new Array();
			$.each(dt,function(index,el){
				tmpArray.push({id:el.id,text:el.name+','+el.days+'天,价格'+el.price});
			});
			$('#vippriceid').select2({width: '60%',data: tmpArray});
		},'json');
	    $('#expire').datepicker({
	    	autoclose:true,
	        format:'yyyy-mm-dd',
	        todayBtn: "linked",          
	        language:'zh-CN'
	     });
	}
});