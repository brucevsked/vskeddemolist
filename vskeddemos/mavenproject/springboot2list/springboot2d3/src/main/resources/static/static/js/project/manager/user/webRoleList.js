'use strict'

$(function(){
	$('#queryBt').on('click',webRoleList.query);
	webRoleList.list();
});

var webRoleList=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/webrolelist',
                type:'post',
                data:function(d){
                	d.token=$('#servertoken').val();
                	d.code=$('#code').val();
                	d.name=$('#name').val();
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
		    stripeClasses: ["odd", "even"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
		    processing: true,  //隐藏加载提示,自行处理
		    serverSide: true,  //启用服务器端分页
		    orderMulti: false,  //启用多列排序
		    order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
		    ordering:false,//关闭排序
		    paging: true,//开启分页
		    pageLength: webCommon.dataTablePageLength,//每页显示10条
		    lengthMenu:webCommon.dataTableLengthMenu,
		    pagingType: "simple_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
		    fnRowCallback:function(nRow,aData,iDataIndex){
		    	return nRow;
		    },
		    dom:'<"html5buttons"B>lTfgitp',
		    buttons:[
		        {
		            text:'添加',
		  	        action:function(e, dt, node, config){
		  	        	webRoleList.toAdd();
		  	        }
		  	    },
		    	{
		            text:'修改',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		webRoleList.toUpdate(selectData[0].id);
		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	    },
		    	{
		            text:'权限绑定',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		webRoleList.toWebRolePermissionBind(selectData[0].id);
		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	    }
		    ],
		  	columns:[
		  	  	{data:'id'},
		  	  	{data:'code'},
		  	  	{data:'name'}
		  	  	]
		 });
		
	},
	query:function(){
		$('#dt0').DataTable().ajax.reload();
	},
    toAdd:function(){
		webCommon.loadPage('/webapi/v1/towebroleadd',{token: $('#servertoken').val() });
	},
	toUpdate:function(fid){
		webCommon.loadPage('/webapi/v1/towebroleupdate',{token: $('#servertoken').val(),fid:fid });
	},
	toWebRolePermissionBind:function(fid){
		webCommon.loadPage('/webapi/v1/towebrolepermissionbind',{token: $('#servertoken').val(),fid:fid });
	}
});