'use strict'

$(function(){
	$('#queryBt').on('click',appUserBalanceHisList.query);
	appUserBalanceHisList.list();
});

var appUserBalanceHisList=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/appuserbalancehislist?token='+$('#servertoken').val(),
                type:'post',
                data:function(d){
                	d.inphone=$('#inphone').val();
                	d.outphone=$('#outphone').val();
                	d.orderid=$('#orderid').val();
                },
                dataType: 'json'
			},
			language:webCommon.dataTableLang,  //提示信息
			select:'single',//可选值os,single,multi 当值为os时可以按住ctrl或shift可以多选
			columnDefs: [{
				targets: [0],
				visible: false,
				searchable: false
				}],
		    searching: false, //隐藏搜索
		    processing: true,  //隐藏加载提示,自行处理
		    serverSide: true,  //启用服务器端分页
		    orderMulti: false,  //启用多列排序
		    order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
		    ordering:false,//关闭排序
		    paging: true,//开启分页
		    pageLength: webCommon.dataTablePageLength,//每页显示10条
		    lengthMenu:webCommon.dataTableLengthMenu,//每页显示多少条列表
		    pagingType: "simple_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
		    fnRowCallback:function(nRow,aData,iDataIndex){
		    	return nRow;
		    },
		    dom:'<"html5buttons"B>lTfgitp',
		    buttons:[	    ],
		  	columns:[
		  	  	{data:'id'},
		  	    {data:'feetype',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('1'==data){
						 rs='充值';
					 }else if('2'==data){
					     rs='转出';
					 }else if('3'==data){
						 rs='观看次数消费';
					 }else if('4'==data){
						 rs='观看钻石消费';
					 }else if('5'==data){
						 rs='vip购买钻石消费';
					 }else if('6'==data){
						 rs='观看次数获取';
					 }else if('7'==data){
						 rs='系统充值';
					 }else if('8'==data){
						 rs='系统扣值';
					 }else{
					     rs='未识别';
					 }
			  	   	 return rs;
			  	}},
			  	{data:'orderid'},
		  	  	{data:'balancebefore'},
		  	  	{data:'consume'},
		  	  	{data:'balanceafter'},
		  	  	{data:'phone'},
		  	    {data:'outphone',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if(data==null || data==undefined ){
						 rs='';
					 }else{
					     rs=data;
					 }
			  	   	 return rs;
			  	}},
		  	    {data:'addtime',
		  	   	 render:function(data, type, full, meta){
		  	   	 return webCommon.dtfmt(data);
		  	   	 }}
		  	  	]
		 });
		
	},
	query:function(){
		$('#dt0').DataTable().ajax.reload();
	},
    toAdd:function(){
		webCommon.loadPage('/webapi/v1/toappuserbalancehisadd',{token: $('#servertoken').val() });
	}
});