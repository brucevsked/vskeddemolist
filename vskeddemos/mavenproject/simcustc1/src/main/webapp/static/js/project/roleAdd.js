
$(function(){
    $.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
    $('#srName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var srName=$('#srName').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		srName: srName 
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('roleAddProc:post','addBt');
}