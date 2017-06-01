
$(function(){
	$('#sdtId').combobox({
	    url:basePath+'dictionaryTypeListDataAll',
	    valueField:'SDTID',
	    textField:'SDTNAME',
	    value:$('#sdtIdOld').val() //设置combobox默认选中值
	});
    $.parser.parse();//重新加载样式
    $('#sdName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var sdId=$('#sdId').val();
	var sdName=$('#sdName').val();
	var sdValue=$('#sdValue').val();
	var sdSort=$('#sdSort').val();
	var sdtId=$('#sdtId').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		sdId: sdId,
		sdName: sdName,
		sdValue:sdValue,
		sdSort:sdSort,
		sdtId:sdtId
		    },function (dt){
		    	toastr.info(dt, '修改结果');
		    	}
		    );
}