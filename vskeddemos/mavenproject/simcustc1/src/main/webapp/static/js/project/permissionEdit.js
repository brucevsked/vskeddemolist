
$(function(){
    $.parser.parse();//重新加载样式
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