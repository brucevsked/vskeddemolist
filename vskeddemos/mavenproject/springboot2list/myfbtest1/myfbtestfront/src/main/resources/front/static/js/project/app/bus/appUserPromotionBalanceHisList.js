'use strict'

$(function(){
	$('#queryBt').on('click',appUserPromotionBalanceHisList.query);
	appUserPromotionBalanceHisList.list();
});

var appUserPromotionBalanceHisList=new Object({
	list: function(){
		var myTable=$('#dt0').DataTable({
			ajax:{
				url:'/webapi/v1/appusepromotionbalancehislist?token='+$('#servertoken').val(),
                type:'post',
                data:function(d){
                	d.inphone=$('#inphone').val();
                	d.outphone=$('#outphone').val();
                	d.orderid=$('#orderid').val();
                	d.invitationcode=$('#invitationcode').val();
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
		    buttons:[		    ],
		  	columns:[
		  	  	{data:'id'},
		  	    {data:'feetype',
			  	 render:function(data, type, full, meta){
			  		 var rs='';
					 if('1'==data){
						 rs='推广收益';
					 }else if('2'==data){
					     rs='提现申请';
					 }else if('3'==data){
						 rs='系统打款';
					 }else if('4'==data){
						 rs='系统返还';
					 }else{
					     rs='未识别';
					 }
			  	   	 return rs;
			  	}},
		  	  	{data:'inphone'},
		  	  	{data:'outphone'},
		  	  	{data:'orderid'},
		  	  	{data:'balancebefore'},
		  	  	{data:'consume'},
		  	  	{data:'balanceafter'},
		  	  	{data:'invitationcode'},
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
		webCommon.loadPage('/webapi/v1/toappuserpromotionbalancehisadd',{token: $('#servertoken').val() });
	}
});