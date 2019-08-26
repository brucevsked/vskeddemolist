'use strict'

$(function(){
	$('#queryBt').on('click',appUserCashHisList.query);
	appUserCashHisList.list();
});

var appUserCashHisList=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/appusercashhislist?token='+$('#servertoken').val(),
                type:'post',
                data:function(d){
                	d.phone=$('#phone').val();
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
		    buttons:[
		        {
		            text:'审核',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		appUserCashHisList.toUserCashReView(selectData[0].id);
		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        	
		  	        }
		  	      }
		    ],
		  	columns:[
		  	  	{data:'id'},
		  	  	{data:'phone'},
		  	  	{data:'orderid'},
		  	  	{data:'consume'},
		  	    {data:'cashstate',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('0'==data){
						 rs='未打款';
					 }else if('1'==data){
					     rs='已打款';
					 }else if('2'==data){
						 rs='审核失败';
					 }else{
					     rs='未识别';
					 }
			  	   	 return rs;
			  	}},
		  	    {data:'cashtype',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('1'==data){
						 rs='支付宝';
					 }else if('2'==data){
					     rs='微信';
					 }else if('3'==data){
						 rs='银行卡';
					 }else if('4'==data){
						 rs='信用卡';
					 }else{
					     rs='未识别';
					 }
			  	   	 return rs;
			  	}},
		  	  	{data:'cashaccount'},
		  	  	{data:'opaccount'},
		  	    {data:'addtime',
		  	   	 render:function(data, type, full, meta){
		  	   	 return webCommon.dtfmt(data);
		  	   	 }},
			  	 {data:'proctime',
			  	  render:function(data, type, full, meta){
			  		  if(data==null) return '';
			  	  return webCommon.dtfmt(data);
			  	 }}
		  	  	]
		 });
		
	},
	query:function(){
		$('#dt0').DataTable().ajax.reload();
	},
	toUserCashReView:function(id){
		webCommon.loadPage('/webapi/v1/toappusercashreview',{token: $('#servertoken').val(),id:id });
	}
});