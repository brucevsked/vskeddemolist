'use strict'

$(function(){
	$('#queryBt').on('click',appVersionList.query);
	appVersionList.initUI();
	appVersionList.list();
});

var appVersionList=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/appversionlist?token='+$('#servertoken').val(),
                type:'post',
                data:function(d){
                	d.devicetype=$('#devicetype').select2('val');
                	d.upcontent=$('#upcontent').val();
                	d.version=$('#version').val();
                },
                dataType: 'json'
			},
			language:webCommon.dataTableLang,  //提示信息
			select:true,//需要Select-1.3.0支持
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
		  	        	appVersionList.toAdd();
		  	        }
		  	    },
		    	{
		            text:'修改',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		appVersionList.toUpdate(selectData[0].id);
		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	    }
		    ],
		  	columns:[
		  	  	{data:'id'},
		  	    {data:'devicetype',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('1'==data){
						 rs='苹果';
					 }else if('2'==data){
					     rs='安卓';
					 }else if('3'==data){
						 rs='winphone';
					 }else{
					     rs='未识别';
					 }
			  	   	 return rs;
			  	}},
		  	  	{data:'name'},
		  	  	{data:'code'},
		  	  	{data:'upcontent'},
		  	  	{data:'version'},
		  	  	{data:'versionidentify'},
		  	  	{data:'updateurl'},
		  	    {data:'state',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('0'==data){
						 rs='强制更新';
					 }else if('1'==data){
					     rs='普通';
					 }else{
					     rs='未识别';
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
		webCommon.loadPage('/webapi/v1/toappversionadd',{token: $('#servertoken').val() });
	},
	toUpdate:function(fid){
		webCommon.loadPage('/webapi/v1/toappversionupdate',{token: $('#servertoken').val(),fid:fid });
	},
	initUI:function(){
		var tmpArray=new Array();
		tmpArray.push({id:1,text:'苹果'});
		tmpArray.push({id:2,text:'安卓'});
		tmpArray.push({id:3,text:'winphone'});
		$('#devicetype').select2({width: '100%',data: tmpArray});
		$('#devicetype').append('<option value="" selected>请选择设备类型</option>');
		$('#devicetype').trigger('change');
	}
});