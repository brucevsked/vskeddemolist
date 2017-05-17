
$(function(){
    $.parser.parse();//重新加载样式
    $('#suName').textbox('textbox').focus(); 
});

/**
 * 添加提交
 * @returns {Boolean}
 */
function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var suName=$('#suName').val();
	var suNick=$('#suNick').val();
	var suPass=$('#suPass').val();
	var suPass1=$('#suPass1').val();
	var suMobile=$('#suMobile').val();
	
	if(suPass!=suPass1){
		toastr.info('两次密码输入不一致', '提示');
		return false;
	}
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		suName: suName ,
		suNick:suNick,
		suPass:suPass,
		suMobile:suMobile
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}