$(function(){
	$('#suName').focus();
});

function toLogin(){
	if($('#suName').val()==''){
		$('#showMsg').html('用户名不能为空！');
		$('#suName').focus();
		return false;
	}
	if($('#suPass').val()==''){
		$('#showMsg').html('密码不能为空！');
		$('#suPass').focus();
		return false;
	}
	$('#loginForm').submit();
	//$('#showMsg').html('让他们继续飞一会吧');
}

$('#loginWin').bind('keyup', function(event) {/* 增加回车提交功能 */
    if (event.keyCode == '13') {
    	toLogin();
    }
}); 