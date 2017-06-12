
$(function(){
    $.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
    $('#sdtName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var sdtId=$('#sdtId').val();
	var sdtName=$('#sdtName').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		sdtId:sdtId,
		sdtName: sdtName 
		    },function (dt){
		    	toastr.info(dt, '修改结果');
		    	}
		    );
}

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('dictionaryTypeEditProc:post','editBt');
}