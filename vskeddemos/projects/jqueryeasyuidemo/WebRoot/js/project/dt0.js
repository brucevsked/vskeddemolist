$(function(){
	var basePath=document.getElementsByTagName('base')[0].href;
	$('#mytb').datagrid({ 
        title:'应用系统列表', 
        iconCls:'icon-edit',//图标 
        width: 350, 
        height: 'auto', 
        nowrap: false, 
        striped: true, 
        border: true, 
        collapsible:false,//是否可折叠的 
        //fit: true,//自动大小 
        url:basePath+'demoproc/dt0proc.jsp', 
        //sortName: 'code', 
        //sortOrder: 'desc', 
        remoteSort:false,  
        idField:'fldId', 
        singleSelect:false,//是否单选 
        pagination:true,//分页控件 
        rownumbers:true,//行号 
        frozenColumns:[[ 
            {field:'ck',checkbox:true} 
        ]], 
        toolbar: [{ 
            text: '添加', 
            iconCls: 'icon-add', 
            handler: function() { 
                console.log("add");
            } 
        }, '-', { 
            text: '修改', 
            iconCls: 'icon-edit', 
            handler: function() { 
            	console.log("edit");
            } 
        }, '-',{ 
            text: '删除', 
            iconCls: 'icon-remove', 
            handler: function(){ 
            	console.log("del");
            } 
        }], 
    }); 
    //设置分页控件 
    var p = $('#mytb').datagrid('getPager'); 
    $(p).pagination({ 
        pageSize: 10,//每页显示的记录条数，默认为10 
        pageList: [5,10,15],//可以设置每页记录条数的列表 
        beforePageText: '第',//页数文本框前显示的汉字 
        afterPageText: '页    共 {pages} 页', 
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
        /*onBeforeRefresh:function(){
            $(this).pagination('loading');
            alert('before refresh');
            $(this).pagination('loaded');
        }*/ 
    }); 
});