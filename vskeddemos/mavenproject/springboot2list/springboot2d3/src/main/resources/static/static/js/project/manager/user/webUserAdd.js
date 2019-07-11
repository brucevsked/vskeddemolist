'use strict'

$(function(){
	$('#addBt').on('click',webUserAdd.add);
	webUserAdd.initUI();
    $('#username').focus();
});

var webUserAdd=new Object({
	addIsClick:true,
	add:function(){
		if(webUserAdd.addIsClick==false) return false;
		var username=$('#username').val();
		var userpass=$('#userpass').val();
		var userpass1=$('#userpass1').val();
		var phone=$('#phone').val();
		var userrole=$('input[name="userrole"]:checked').val();
		
		if(username.length<=0){
			toastr.error('用户名不能为空');
			$('#username').focus();
			return false;
		}
		if(userpass.length<=0){
			toastr.error('用户密码不能为空');
			$('#userpass').focus();
			return false;
		}
		if(userpass1.length<=0){
			toastr.error('用户确认密码不能为空');
			$('#userpass1').focus();
			return false;
		}
		if(userpass!=userpass1){
			toastr.error('两次密码不一致!');
			$('#userpass').focus();
			return false;
		}
		if(phone.length<=0){
			toastr.error('用户手机号不能为空');
			$('#phone').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/webuseradd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			username: username ,
			userpass:userpass,
			userrole:userrole,
			phone:phone
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		webUserAdd.addIsClick=false;
		setTimeout(function() {	webUserAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	},
	initUI:function(){
		$.post('/webapi/v1/webrolelist1',{token:$('#servertoken').val()},function (dt){
			var roleList='';
			var flag=false;
			var ck=' checked '
			$.each(dt,function(index,el){
				roleList+='<input type="radio" class="i-checks" value="'+el.id+'" name="userrole" '+ck+'>'+el.name+'&nbsp;&nbsp;';
				if(flag==false){
					ck='';
					flag=true;
				}
			});
			$('#userRoleDiv').html(roleList);
			webCommon.initICheck();
		},'json');
	}
});