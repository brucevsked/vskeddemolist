
$(function(){
    $.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
    $('#spName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var spId=$('#spId').val();
	var spName=$('#spName').val();
	var spNick=$('#spNick').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		spId:spId,
		spName: spName,
		spNick:spNick
		    },function (dt){
		    	toastr.info(dt, '修改结果');
		    	}
		    );
}

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('permissionEditProc:post','editBt');
}