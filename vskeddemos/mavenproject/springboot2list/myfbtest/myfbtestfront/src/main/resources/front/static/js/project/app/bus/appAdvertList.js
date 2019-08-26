'use strict'

$(function(){
	$('#queryBt').on('click',appAdvertList.query);
	appAdvertList.initUI();
	appAdvertList.list();
});

var appAdvertList=new Object({
	list: function(){
		$('#type1').select2();
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/appadvertlist?token='+$('#servertoken').val(),
                type:'post',
                data:function(d){
                	d.avname=$('#avname').val();
                	d.type1=$('#type1').select2('val');
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
		  	        	appAdvertList.toAdd();
		  	        }
		  	    },
		    	{
		            text:'修改',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		appAdvertList.toUpdate(selectData[0].id);
		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	    },
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
		    		  	        		
		    		  	        		var myBasePath='/webapi/v1/appadvertdel';
		    		  	        		if(myIdsArray.length>0){
		    		  	        			$.post(myBasePath,{token:$('#servertoken').val(),ids:myIdsArray.join(',')},function (dt){
		    		  	        				if('000000'==dt.code){
		    		  	        					swal("删除", "选中项目已被删除.", "success");
		    		  	        					appAdvertList.query();
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
		  	  	{data:'name'},
		  	  	{data:'type1name'},
		  	    {data:'targettype',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('0'==data){
						 rs='外链';
					 }else if('1'==data){
					     rs='播放影片';
					 }else if('2'==data){
						 rs='影星详情';
					 }else if('3'==data){
						 rs='充值';
					 }else if('4'==data){
						 rs='推广';
					 }else if('5'==data){
						 rs='浏览器';
					 }else{
					     rs='未识别状态';
					 }
			  	   	 return rs;
			  	}},
		  	    {data:'storeurls',
			  	 render:function(data, type, full, meta){
			  		return '<img src="'+data+'" width=150 height=150 />';
			  	}},
			  	{data:'target'},
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
		webCommon.loadPage('/webapi/v1/toappadvertadd',{token: $('#servertoken').val() });
	},
	toUpdate:function(fid){
		webCommon.loadPage('/webapi/v1/toappadvertupdate',{token: $('#servertoken').val(),fid:fid });
	},
	initUI:function(){
		$.post('/webapi/v1/appadverttypelistdata',{token:$('#servertoken').val()},function (dt){
			  var tmpArray=new Array();
			  $.each(dt,function(index,el){
			    tmpArray.push({id:el.id,text:el.name});
			  });
			  $('#type1').select2({width: '100%',data: tmpArray});
			  $('#type1').append('<option value="" selected>请选择广告类型</option>');
			  $('#type1').trigger('change');
		    },'json');
	}
});