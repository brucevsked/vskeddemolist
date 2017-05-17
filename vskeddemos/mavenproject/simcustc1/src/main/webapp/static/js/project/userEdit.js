
$(function(){
    $.parser.parse();//重新加载样式
    $('#suNick').textbox('textbox').focus(); 
});

/**
 * 修改提交
 * @returns {Boolean}
 */
function submitForm(){
	if(!$("#fm").form('validate')){
		return false;
    }
	
	var suId=$('#suId').val();
	var suNick=$('#suNick').val();
	var suMobile=$('#suMobile').val();
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		suId:suId,
		suNick: suNick ,
		suMobile:suMobile
		    },function (dt){
		    	toastr.info(dt, '修改结果');
		    	}
		    );
}