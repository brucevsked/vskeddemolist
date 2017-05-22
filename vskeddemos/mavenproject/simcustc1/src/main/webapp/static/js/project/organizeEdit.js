
$(function(){
	$('#parentSoId').combotree({
	    url:basePath+'organizeListDataAll',
	    loadFilter: function (rows) {  
            return convertEasyUITreeData(rows);  
        }  
});
    $.parser.parse();//重新加载样式
	$('#parentSoId').combotree('setValues',$('#paremtSoIdOld').val());
    $('#soName').textbox('textbox').focus();
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var soId=$('#soId').val();
	var soName=$('#soName').val();
	var parentSoId=$('#parentSoId').val();
	var soCode=$('#soCode').val();
	var soSort=$('#soSort').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		soId: soId,
		soName: soName,
		parentSoId:parentSoId,
		soCode:soCode,
		soSort:soSort
		    },function (dt){
		    	toastr.info(dt, '修改结果');
		    	}
		    );
}

function emptyParentSoId(){
	$('#parentSoId').combotree('setValues','');
}