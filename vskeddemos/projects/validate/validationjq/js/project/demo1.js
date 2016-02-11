$(function(){
	console.log(1);
	$("#fm0").validate({
		rules: {
			userName:{required: true,minlength: 5,maxlength:10},
			userPass:{required: true,minlength: 5,maxlength:10}
		}
		//,debug:true //不提交这个表单 生产环境要去了			
		}
		);
});