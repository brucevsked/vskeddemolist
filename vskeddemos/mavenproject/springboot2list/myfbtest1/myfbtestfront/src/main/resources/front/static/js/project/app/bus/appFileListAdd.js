'use strict'

$(function(){
	$('#addBt').on('click',appFileListAdd.add);
	appFileListAdd.initUI();
});

var appFileListAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appFileListAdd.addIsClick==false) return false;
		
		var formData = new FormData();
		var myFile1=$('#myFile')[0].files[0];
		var myType=$('#type1').select2('val');
    	formData.append("myFile" , myFile1);
    	formData.append("type" , myType);
    	formData.append("sourcetype" , 2);
    	formData.append("token" , $('#servertoken').val());
    	$.ajax({
			type: "POST",
			url: '/webapi/v1/appfilelistadd',
			data: formData,			//这里上传的数据使用了formData 对象
			processData : false, 	//必须false才会自动加上正确的Content-Type
			contentType : false,
			
			//上传成功后回调
			success: function(dt){
				  dt = $.parseJSON(dt);
				  if('000000'==dt.code){
					  toastr.success(dt.msg);
				  }else{
					  toastr.error(dt.msg);
				  }
			},
			error: function(){//上传失败后回调
				toastr.error('上传文件失败!');
			}
			
		});
    	
    	appFileListAdd.addIsClick=false;
		setTimeout(function() {	appFileListAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
		
	},
	initUI:function(){
		$('#type1').select2({width: '60%'});
        $('#myFile').on('change', function() {
            var fileName = $(this).val().split('\\').pop();
            $(this).next('.custom-file-label').addClass("selected").html(fileName);
        });
		
	}
});