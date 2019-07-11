'use strict'

$(function(){
	$('#queryBt').on('click',appUserSearchHisList.query);
	appUserSearchHisList.list();
});

var appUserSearchHisList=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/appusersearchhislist?token='+$('#servertoken').val(),
                type:'post',
                data:function(d){
                	d.phone=$('#phone').val();
                	d.content=$('#content').val();
                },
                dataType: 'json'
			},
			language:webCommon.dataTableLang,  //提示信息
			select:'os',//可选值os,single,multi 当值为os时可以按住ctrl或shift可以多选
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
		            text:'删除',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		swal({
		  	        			title: "你确定？",
		                        text: "你将无法恢复这些被选中的记录！",
		                        type: "warning",
		                        showCancelButton: true,
		                        confirmButtonColor: "#DD6B55",
		                        confirmButtonText: "删除",
		                        cancelButtonText: "取消",
		                        closeOnConfirm: false,
		                        closeOnCancel: true 
		                        },function (isConfirm) {
		                        	if (isConfirm) {
		    		  	        		var myIdsArray=new Array();
		    		  	        		$.each(selectData,function(indexa,ela){
		    		  	        			myIdsArray.push(ela.id);
		    		  	        		});
		    		  	        		
		    		  	        		var myBasePath='/webapi/v1/appusersearchhisdel';
		    		  	        		if(myIdsArray.length>0){
		    		  	        			$.post(myBasePath,{token:$('#servertoken').val(),ids:myIdsArray.join(',')},function (dt){
		    		  	        				if('000000'==dt.code){
		    		  	        					swal("删除", "选中项目已被删除.", "success");
		    		  	        					appUserSearchHisList.query();
				    		  	  			    }else{
				    		  	  				    swal("取消", "选中项目删除失败:"+dt.msg, "error");
				    		  	  			    }
				    		  	  			    
				    		  	  	        },'json');
		    		  	      			
		    		  	      		    }//end if myIdsArray
		                            }
		                    });

		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	      }
		    ],
		  	columns:[
		  	  	{data:'id'},
		  	  	{data:'phone'},
		  	  	{data:'username'},
		  	  	{data:'content'},
		  	    {data:'addtime',
		  	   	 render:function(data, type, full, meta){
		  	   	 return webCommon.dtfmt(data);
		  	   	 }}
		  	  	]
		 });
		
	},
	query:function(){
		$('#dt0').DataTable().ajax.reload();
	}
});