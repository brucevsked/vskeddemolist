
$(function(){
    $.parser.parse();//重新加载样式
	initPagePermission(); //权限初始化
    $('#suPass').textbox('textbox').focus(); 
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
	var suPass=$('#suPass').val();
	var suPass1=$('#suPass1').val();
	
	if(suPass!=suPass1){
		toastr.info('两次密码输入不一致', '提示');
		return false;
	}
	
	var myBasePath=$('#fm').attr("action");
	
	$.post(myBasePath,
			{
		suId:suId,
		suPass:suPass
		    },function (dt){
		    	toastr.info(dt, '修改结果');
		    	}
		    );
}

/**
 * 初始化权限,将没权限的按钮移除
 */
function initPagePermission(){
	isExistPermission('userPassProc:post','editBt');
}