
$(function(){
$('#parentSoId').combotree({
	    url:basePath+'organizeListDataAll',
	    loadFilter: function (rows) {  
            return convertEasyUITreeData(rows);  
        }  
});
    $.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
    $('#soName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var soName=$('#soName').val();
	var parentSoId=$('#parentSoId').val();
	var soCode=$('#soCode').val();
	var soSort=$('#soSort').val();
	
	var myBasePath=$('#fm').attr("action");
	$.post(myBasePath,
			{
		soName: soName,
		parentSoId:parentSoId,
		soCode:soCode,
		soSort:soSort
		
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}

function emptyParentSoId(){
	$('#parentSoId').combotree('setValues','');
}

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('organizeAddProc:post','addBt');
}