'use strict'

$(function(){
	appModuleTypeList.list();
});

var appModuleTypeList=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/appmoduletypelist?token='+$('#servertoken').val(),
                type:'post',
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
		            text:'添加',
		  	        action:function(e, dt, node, config){
		  	        	appModuleTypeList.toAdd();
		  	        }
		  	    },
		    	{
		            text:'修改',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		appModuleTypeList.toUpdate(selectData[0].id);
		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	    }
		    ],
		  	columns:[
		  	  	{data:'id'},
		  	  	{data:'name'},
		  	  	{data:'description'},
		  	  	{data:'seq'},
		  	    {data:'state',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('0'==data){
						 rs='禁用';
					 }else if('1'==data){
					     rs='启用';
					 }else{
					     rs='未识别状态';
					 }
			  	   	 return rs;
			  	}}
		  	  	]
		 });
		
	},
    toAdd:function(){
		webCommon.loadPage('/webapi/v1/toappmoduletypeadd',{token: $('#servertoken').val() });
	},
	toUpdate:function(fid){
		webCommon.loadPage('/webapi/v1/toappmoduletypeupdate',{token: $('#servertoken').val(),fid:fid });
	}
});