'use strict'

$(function(){
	$('#queryBt').on('click',appVideoList.query);
	appVideoList.initUI();
	appVideoList.list();
});

var appVideoList=new Object({
	list: function(){
		$('#type1').select2();
		$('#type2').select2();
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/appvideolist?token='+$('#servertoken').val(),
                type:'post',
                data:function(d){
                	d.vname=$('#vname').val();
                	d.vdescription=$('#vdescription').val();
                	d.type1=$('#type1').select2('val');
                	d.type2=$('#type2').select2('val');
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
		            text:'添加',
		  	        action:function(e, dt, node, config){
		  	        	appVideoList.toAdd();
		  	        }
		  	    },
		    	{
		            text:'修改',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		appVideoList.toUpdate(selectData[0].id);
		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	    },
		    	{
		            text:'绑定影星',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		appVideoList.toHumanVideoInfoBind(selectData[0].id);
		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	    },
		    	{
		            text:'绑定播放地址',
		  	        action:function(e, dt, node, config){
		  	        	var selectData=myTable.rows('.selected').data();
		  	        	if(selectData.length>0){
		  	        		appVideoList.toVideoStoreUrlBind(selectData[0].id);
		  	        	}else{
		  	        		toastr.info('请选择数据');
		  	        	}
		  	        }
		  	    }
		  	    
		    ],
		  	columns:[
		  	  	{data:'id'},
		  	  	{data:'type1name'},
		  	  	{data:'type2name'},
		  	  	{data:'name'},
		  	  	{data:'description'},
		  	  	{data:'coverurls',render:function(data, type, full, meta){
		  	  		return '<img src="'+data+'" width=150 height=150 />';
		  	  	}},
		  	    {data:'iscommend',render:function(data, type, full, meta){
		  	    	var rs='';
		  	    	if('0'==data){
		  	    		rs='否';
		  	    	}else if('1'==data){
		  	    		rs='是';
		  	    	}else{
		  	    		rs='未识别';
		  	    	}
		  	    	return rs;
		  	    }},
		  	    {data:'ishot',
		  	     render:function(data, type, full, meta){
		  	    	var rs='';
		  	    	if('0'==data){
		  	    		rs='否';
		  	    	}else if('1'==data){
		  	    		rs='是';
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
		webCommon.loadPage('/webapi/v1/toappvideoadd',{token: $('#servertoken').val() });
	},
	toUpdate:function(fid){
		webCommon.loadPage('/webapi/v1/toappvideoupdate',{token: $('#servertoken').val(),fid:fid });
	},
	toHumanVideoInfoBind:function(fid){
		webCommon.loadPage('/webapi/v1/toapphumanvideoinfobind',{token: $('#servertoken').val(),fid:fid });
	},
	toVideoStoreUrlBind:function(fid){
		webCommon.loadPage('/webapi/v1/toappvideostoreurlbind',{token: $('#servertoken').val(),fid:fid });
	},
	initUI:function(){
		$.post('/webapi/v1/appvideotypelistbylevel',{token:$('#servertoken').val(),level:1},function (dt){
			  var tmpArray=new Array();
			  $.each(dt,function(index,el){
			    tmpArray.push({id:el.id,text:el.name});
			  });
			  $('#type1').select2({width: '20%',data: tmpArray});
			  $('#type1').append('<option value="" selected>请选择1级分类</option>');
			  $('#type1').trigger('change');
		    },'json');
		
		$.post('/webapi/v1/appvideotypelistbylevel',{token:$('#servertoken').val(),level:2},function (dt){
			  var tmpArray=new Array();
			  $.each(dt,function(index,el){
			    tmpArray.push({id:el.id,text:el.name});
			  });
			  $('#type2').select2({width: '35%',data: tmpArray});
			  $('#type2').append('<option value="" selected>请选择2级分类</option>');
			  $('#type2').trigger('change');
		    },'json');
	}
});