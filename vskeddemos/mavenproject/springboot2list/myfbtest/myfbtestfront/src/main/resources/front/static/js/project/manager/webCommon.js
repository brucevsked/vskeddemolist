'use strict'

var basePath = document.getElementsByTagName('base')[0].href;

$(function(){
	
    toastr.options = {
            closeButton: true,
            progressBar: true,
            showMethod: 'slideDown',
            timeOut: 4000
        };
});

var webCommon=new Object({
	dtfmtlist:{fmt1:'yyyy-MM-dd',fmt2:'HH:mm:ss',fmt3:'yyyy-MM-dd HH:mm:ss'},
	dtfmt:function(dt){
		dt=parseInt(dt);
		//需要luxon库支持
		var d=luxon.DateTime.fromMillis(dt);
		return d.toFormat(webCommon.dtfmtlist.fmt1)
	},
	dtfmt3:function(dt){
		dt=parseInt(dt);
		//需要luxon库支持
		var d=luxon.DateTime.fromMillis(dt);
		return d.toFormat(webCommon.dtfmtlist.fmt3)
	},
	getCurDate1:function(){
		return luxon.DateTime.local().toFormat(webCommon.dtfmtlist.fmt1);
	},
	logout: function(){
		$(location).prop('href', basePath+'SysUserController/tologout.html');
	},
	loadPage:function(pageUrl,data,callback){
		$('#mainContent').load(pageUrl,data,callback);
	},
	testreset:function(){
		//$('#suName').val('admin');
		//$('#suName').focus();
	},
    //提示信息
    dataTableLang: {
        "sProcessing": "处理中...",
        "sLengthMenu": "每页 _MENU_ 行",
        "sZeroRecords": "没有匹配结果",
        "sInfo": "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
        "sInfoEmpty": "当前显示第 0 至 0 项，共 0 项",
        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
        "sInfoPostFix": "",
        "sSearch": "搜索:",
        "sUrl": "",
        "sEmptyTable": "表中数据为空",
        "sLoadingRecords": "载入中...",
        "sInfoThousands": ",",
        "select":{
        	"rows":{
        		_: "已选择  %d 行",
        		1: "已选择 1 行"
        	}
        },
        "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页",
            "sJump": "跳转"
        },
        "oAria": {
            "sSortAscending": ": 以升序排列此列",
            "sSortDescending": ": 以降序排列此列"
        }
    },
    dataTablePageLength:10,
    dataTableLengthMenu:[1,2,5,10,20,25,30,35,40,50,60,70,80,90,100],
    initICheck:function(){
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    },
    menuActive:function(menuItem){
        $.each($(menuItem).parent().parent().parent().parent().find('li'),function(index,el){
            $(el).removeClass('active'); 
        });
        $(menuItem).parent().attr('class','active');
        $(menuItem).parent().parent().parent().attr('class','active');  	
    },
    test:function(){
    	
    }
});