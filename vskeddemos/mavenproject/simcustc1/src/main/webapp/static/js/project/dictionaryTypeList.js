
$(function(){
	$('#mytb').datagrid({
		title:'字典类型列表',
        height: 'auto',
        fitColumns:true,
        nowrap: true, 
        striped: true,
        border: true, 
        url:basePath+'dictionaryTypeListData',
        idField:'SDTID', 
        singleSelect:true,//是否单选 
        pagination:true,//分页控件 
        rownumbers:true //行号 
    });
	
    //设置分页控件 
    var p = $('#mytb').datagrid('getPager'); 
    $(p).pagination({ 
        pageSize: 10,//每页显示的记录条数，默认为10 
        pageList: [5,10,15,20,25,30,35,40,45,50],//可以设置每页记录条数的列表 
        beforePageText: '第',//页数文本框前显示的汉字 
        afterPageText: '页    共 {pages} 页', 
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
    });
    
	$.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
    $('#sdtName').textbox('textbox').focus(); 
    
});

function query(){
	var sdtName=$('#sdtName').val();
	$('#mytb').datagrid('load',{
		sdtName: sdtName		
	});
}

function edit(){
	var row = $('#mytb').datagrid('getSelected');
	if (row){
		loadPage('dictionaryTypeEditPage?sdtId='+row.SDTID);
	}else{
		toastr.info('请选择行', '提示');
	}
}

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('dictionaryTypeListData:post','queryBt');
	isExistPermission('dictionaryTypeEditPage:get','editBt');
}