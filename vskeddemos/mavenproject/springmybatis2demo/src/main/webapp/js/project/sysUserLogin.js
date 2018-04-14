'use strict'

$(function(){
	$('#suName').focus();
	$('#loginBt').on('click',sysUserLogin.login);
	$('#resetBt').on('click',sysUserLogin.reset);
});

var sysUserLogin=new Object({
	login: function(){
		var suName=$('#suName').val();
		var suPass=$('#suPass').val();
		if(suName==''){
			$('#backResult').html('用户名不能为空');
			$('#suName').focus();
		}else if(suPass==''){
			$('#backResult').html('密码不能为空');
			$('#suPass').focus();
		}else{
			var myBasePath=basePath+'SysUserController/sysUserLoginPc.html';
			suPass=hex_md5(suPass);
			$.post(myBasePath,{ suName: suName,suPass:suPass },function (dt){
				if(dt.code!='0'){
					$('#backResult').html(dt.msg);
				}else{
					$(location).prop('href', basePath+'SysUserController/toIndex.html');
				}
			},"json");
		}
	},
	reset:function(){
		$('#suName').val('');
		$('#suPass').val('');
		$('#suName').focus();
	}
});