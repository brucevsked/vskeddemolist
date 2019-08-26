'use strict'

$(function(){
	balanceReport.list();
	balanceReport.list1();
});

var balanceReport=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/balancereport?token='+$('#servertoken').val(),
                type:'post',
                dataType: 'json'
			},
			language:webCommon.dataTableLang,  //提示信息
		    searching: false, //隐藏搜索
            paging:false, //关闭分页
            ordering:false,//关闭排序
            info:false,  //关闭信息		    
		  	columns:[
		  	  	{data:'balance'},
		  	  	{data:'rechargesum'},
		  	  	{data:'consumesum'},
		  	    {data:'outchargesum'},
		  	    {data:'viewvideocount'},
		  	    {data:'viewvideocountsum'}
		  	  	]
		 });
	},
	list1: function(){
		var myTable=$('#dt1').DataTable({
			ajax:{
				url:'/webapi/v1/balancereport1?token='+$('#servertoken').val(),
                type:'post',
                dataType: 'json'
			},
			language:webCommon.dataTableLang,  //提示信息
		    searching: false, //隐藏搜索
            paging:false, //关闭分页
            ordering:false,//关闭排序
            info:false,  //关闭信息		    
		  	columns:[
		  	  	{data:'todayreg'},
		  	  	{data:'allreg'},
		  	  	{data:'todaydiamondin'},
		  	    {data:'todaydiamondout'},
		  	    {data:'alldiamond'}
		  	  	]
		 });
	}
});