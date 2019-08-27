'use strict'

$(function(){
	$('#queryBt').on('click',appUserList.query);
	appUserList.list();
});

var appUserList=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'webapi/v1/appuserlist?token='+$('#servertoken').val(),
                type:'post',
                data:function(d){
                	d.phone=$('#phone').val();
                	d.username=$('#username').val();
                	d.myinvitationcode=$('#myinvitationcode').val();
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
		    stripeClasses: ["odd", "even"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
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
		            text:'修改',
		            className:'btn btn-w-m btn-primary',
		  	        action:function(e, dt, node, config){
		  		      var selectData=myTable.rows('.selected').data();
		  	        if(selectData.length>0){
		  	          appUserList.toappuserupdate(selectData[0].uid);
		  	        }else{
		  	        	toastr.info('请选择数据后再修改');
		  	        }		  	        	
		  	        }
		  	    },
		        {
		            text:'充扣值',
		            className:'btn btn-w-m btn-primary',
		  	        action:function(e, dt, node, config){
		  		      var selectData=myTable.rows('.selected').data();
		  	        if(selectData.length>0){
		  	          appUserList.toappuserbalanceupdate(selectData[0].uid);
		  	        }else{
		  	        	toastr.info('请选择数据后再修改');
		  	        }		  	        	
		  	        }
		  	    },
		        {
		            text:'密码重置',
		            className:'btn btn-w-m btn-primary',
		  	        action:function(e, dt, node, config){
		  		      var selectData=myTable.rows('.selected').data();
		  	        if(selectData.length>0){
		  	          appUserList.topassreset(selectData[0].uid);
		  	        }else{
		  	        	toastr.info('请选择数据后再修改');
		  	        }		  	        	
		  	        }
		  	    }

		    ],
		  	columns:[
		  	  	{data:'uid'},
		  	  	{data:'username'},
		  	  	{data:'phone'},
		  	  	{data:'balance'},
		  	  	{data:'balancecash'},
		  	  	{data:'balancefreeze'},
		  	  	{data:'rechargesum'},
		  	  	{data:'consumesum'},
		  	  	{data:'outchargesum'},
		  	  	{data:'viewvideocount'},
		  	  	{data:'videocountext'},
		  	  	{data:'myinvitationcode'},
		  	    {data:'isagent',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('0'==data){
						 rs='用户';
					 }else if('1'==data){
					     rs='代理';
					 }else if('2'==data){
						 rs='客服';
					 }else{
					     rs='未识别';
					 }
			  	   	 return rs;
			  	}},
		  	    {data:'status',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('1'==data){
						 rs='正常';
					 }else if('2'==data){
					     rs='锁定';
					 }else if('3'==data){
					     rs='删除';
					 }else if('4'==data){
					     rs='非法';
					 }else{
					     rs='未识别状态';
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
	toappuserbalanceupdate:function(fuid){
		webCommon.loadPage('webapi/v1/toappuserbalanceupdate',{token: $('#servertoken').val(),fuid:fuid });
	},
	toappuserupdate:function(fuid){
		webCommon.loadPage('webapi/v1/toappuserupdate',{token: $('#servertoken').val(),fuid:fuid });
	},
	topassreset:function(fuid){
		webCommon.loadPage('webapi/v1/toappuserpassreset',{token: $('#servertoken').val(),fuid:fuid });
	}
});