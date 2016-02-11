$(function(){
	console.log(1);
	$("#fm0").validate({
		rules: {
			userName:{required: true,minlength: 5,maxlength:10},
			userPass:{required: true,minlength: 5,maxlength:10},
			userRePass:{required: true,minlength: 5,maxlength:10,equalTo: "#userPass"}
		},
		messages:{
			userName:{required:'请输入用户名',minlength:'用户名不能少于5个字符',maxlength:'用户名最大不能超过10个字符'},
			userPass:{required:'请输入密码',minlength:'密码不能少于5个字符',maxlength:'密码最大不能超过10个字符'},
			userRePass:{required:'请输入确认密码',equalTo:'两次密码不一致'}
		}
		//,debug:true //不提交这个表单 生产环境要去了			
		}
		);
});