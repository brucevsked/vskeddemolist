
$(function(){
$('#parentSmId').combobox({
	    url:basePath+'menuListDataAll',
	    valueField:'SMID',
	    textField:'SMNAME'
});
    $.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
    $('#smName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var smName=$('#smName').val();
	var smHref=$('#smHref').val();
	var smClick=$('#smClick').val();
	var smClass=$('#smClass').val();
	var smDataOptions=$('#smDataOptions').val();
	var parentSmId=$('#parentSmId').val();
	
	var myBasePath=$('#fm').attr("action");
	$.post(myBasePath,
			{
		smName: smName,
		smHref:smHref,
		smClick:smClick,
		smClass:smClass,
		smDataOptions:smDataOptions,
		parentSmId:parentSmId
		
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('menuAddProc:post','addBt');
}