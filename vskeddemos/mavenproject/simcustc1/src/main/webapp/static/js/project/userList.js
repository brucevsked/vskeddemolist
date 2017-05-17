
$(function(){
	
	$('#mytb').datagrid({
		title:'用户列表',
        height: 'auto',
        fitColumns:true,
        nowrap: true, 
        striped: true,
        border: true, 
        url:basePath+'userListData',
        idField:'SUID', //指定主键字段
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
	
    $('#suName').textbox('textbox').focus(); 
    
});

/**
 * 查询方法
 */
function query(){
	var suName=$('#suName').val();
	$('#mytb').datagrid('load',{
		suName: suName		
	});
}

/**
 * 修改方法
 */
function edit(){
	var row = $('#mytb').datagrid('getSelected');
	if (row){
		loadPage('userEditPage?suId='+row.SUID);
	}else{
		toastr.info('请选择行', '提示');
	}
}

/**
 * 转到为用户绑定角色页面
 */
function userRole(){
	var row = $('#mytb').datagrid('getSelected');
	if (row){
		loadPage('userRoleListPage?suId='+row.SUID);
	}else{
		toastr.info('请选择行', '提示');
	}
}

/**
 * 修改选中用户密码
 */
function userPass(){
	var row = $('#mytb').datagrid('getSelected');
	if (row){
		loadPage('userPassPage?suId='+row.SUID);
	}else{
		toastr.info('请选择行', '提示');
	}
}