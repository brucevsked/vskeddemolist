'use strict'

$(function(){
	$('#addBt').on('click',appAdvertAdd.add);
	$('#uploadFile1Bt').on('click',appAdvertAdd.uploadFile);
	appAdvertAdd.initUI();
    $('#avname').focus();
});

var appAdvertAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appAdvertAdd.addIsClick==false) return false;
		
		var type1=$('#type1').select2('val');
		var name=$('#avname').val();
		var targettype=$('#targettype').select2('val');
		var target=$('#target').val();
		var seq=$('#seq').val();
		var storeurls=$('#storeurls').val();
		
		if(name.length<2){
			toastr.error('名称不能为空');
			$('#avname').focus();
			return false;
		}
		if(storeurls.length<=0){
			toastr.error('广告图片不能为空');
			$('#storeurls').focus();
			return false;
		}
		if(target.length<=0){
			toastr.error('目标链接不能为空');
			$('#target').focus();
			return false;
		}
		if(seq.length<=0){
			toastr.error('序列不能为空');
			$('#seq').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appadvertadd';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			type1:type1,
			name: name ,
			targettype: targettype ,
			target: target ,
			seq:seq,
			storeurls:storeurls
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appAdvertAdd.addIsClick=false;
		setTimeout(function() {	appAdvertAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	uploadFile:function(){
		var formData = new FormData();
		var myFile1=$('#myFile')[0].files[0];
		var myType=5;
    	formData.append("myFile" , myFile1);
    	formData.append("type" , myType);
    	formData.append("sourcetype" , 2);
    	formData.append("token" , $('#servertoken').val());
    	$.ajax({
			type: "POST",
			url: '/webapi/v1/appfileadd2',
			data: formData,			//这里上传的数据使用了formData 对象
			processData : false, 	//必须false才会自动加上正确的Content-Type
			contentType : false,
			
			//上传成功后回调
			success: function(dt){
				  dt = $.parseJSON(dt);
				  if('000000'==dt.code){
					  $('#storeurls').val(dt.msg)
				  }else{
					  toastr.error(dt.msg);
				  }
			},
			error: function(){//上传失败后回调
				toastr.error('上传文件失败!');
			}
			
		});
	},
	initUI:function(){
		$.post('/webapi/v1/appadverttypelistdata',{token:$('#servertoken').val(),level:1},function (dt){
			  var tmpArray=new Array();
			  $.each(dt,function(index,el){
			    tmpArray.push({id:el.id,text:el.name});
			  });
			  $('#type1').select2({width: '60%',data: tmpArray});
		    },'json');
		$('#targettype').select2({width: '60%'});
		
        $('#myFile').on('change', function() {
            var fileName = $(this).val().split('\\').pop();
            $(this).next('.custom-file-label').addClass("selected").html(fileName);
        });
	}
});