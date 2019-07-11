'use strict'

$(function(){
	//$('#loginBt').on('click',webUserLogin.login);
	//$('#resetBt').on('click',webUserLogin.reset);
	$('#username').focus();
});

var webUserLogin=new Object({
	login: function(){
		var username=$('#username').textbox('getValue');
		var userpass=$('#userpass').textbox('getValue');
		if(username==''){
			$('#showMsg').html('用户名不能为空！');
			$('#username').textbox('textbox').focus();
			return false;
		}
		if(userpass==''){
			$('#showMsg').html('密码不能为空！');
			$('#userpass').textbox('textbox').focus();
			return false;
		}
		var myBasePath='';
		myBasePath+=basePath+'SysUserController/webUserLoginPc.html';
		$.post(myBasePath,{ username: username,userpass: userpass },function (dt){
			if(dt.code!='0'){
				$('#showMsg').html(dt.msg);
			}else{
				$(location).prop('href', basePath+'SysUserController/toIndex.html');
			}
		},"json");
	},
	reset:function(){
		$('#username').val('');
		$('#userpass').val('');
		$('#username').focus();
	}
});