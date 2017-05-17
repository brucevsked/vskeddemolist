
$(function(){
    $.parser.parse();//重新加载样式
    $('#srName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var srId=$('#srId').val();
	var srName=$('#srName').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		srId:srId,
		srName: srName 
		    },function (dt){
		    	toastr.info(dt, '修改结果');
		    	}
		    );
}