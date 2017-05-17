
$(function(){
    $.parser.parse();//重新加载样式
    $('#spName').textbox('textbox').focus(); 
});

function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var spName=$('#spName').val();
	var spNick=$('#spNick').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		spName: spName,
		spNick:spNick
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}