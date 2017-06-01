
$(function(){
    $.parser.parse();//重新加载样式
    $('#sdtName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var sdtName=$('#sdtName').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		sdtName: sdtName 
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}