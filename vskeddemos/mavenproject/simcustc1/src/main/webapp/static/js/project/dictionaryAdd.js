
$(function(){
$('#sdtId').combobox({
	    url:basePath+'dictionaryTypeListDataAll',
	    valueField:'SDTID',
	    textField:'SDTNAME'
});
    $.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
    $('#sdName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var sdName=$('#sdName').val();
	var sdtId=$('#sdtId').val();
	var sdValue=$('#sdValue').val();
	var sdSort=$('#sdSort').val();
	
	var myBasePath=$('#fm').attr("action");
	$.post(myBasePath,
			{
		sdName: sdName,
		sdtId:sdtId,
		sdValue:sdValue,
		sdSort:sdSort
		
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('dictionaryAddProc:post','addBt');
}