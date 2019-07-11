'use strict'

$(function(){
	$('#updateBt').on('click',webUserUpdate.update);
	webUserUpdate.initUI();
    $('#username').focus();
});

var webUserUpdate=new Object({
	updateIsClick:true,
	update:function(){
		if(webUserUpdate.updateIsClick==false) return false;
		var fuid=$('#fuid').val();
		var username=$('#username').val();
		var phone=$('#phone').val();
		var userrole=$('input[name="userrole"]:checked').val();
		
		if(username.length<=0){
			toastr.error('用户名不能为空');
			$('#username').focus();
			return false;
		}

		if(phone.length<=0){
			toastr.error('用户手机号不能为空');
			$('#phone').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/webuserupdate';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fuid:fuid,
			username: username ,
			userrole:userrole,
			phone:phone			
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		webUserUpdate.updateIsClick=false;
		setTimeout(function() {	webUserUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	},
	initUI:function(){
		$.post('/webapi/v1/webrolelist1',{token:$('#servertoken').val()},function (dt){
			var roleList='';
			$.each(dt,function(index,el){
				roleList+='<input type="radio" class="i-checks" value="'+el.id+'" name="userrole" '+(el.id==$('#oldUserRole').val()?' checked ':'')+'>'+el.name+'&nbsp;&nbsp;';
			});
			$('#userRoleDiv').html(roleList);
			webCommon.initICheck();
		},'json');
	}
});