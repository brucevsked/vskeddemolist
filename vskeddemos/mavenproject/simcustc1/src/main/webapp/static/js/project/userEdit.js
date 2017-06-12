
$(function(){
    $.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
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

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('userEditProc:post','editBt');
}