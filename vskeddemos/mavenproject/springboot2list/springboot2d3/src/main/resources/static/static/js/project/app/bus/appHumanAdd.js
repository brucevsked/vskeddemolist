'use strict'

$(function(){
	$('#addBt').on('click',appHumanAdd.add);
	$('#uploadFile1Bt').on('click',appHumanAdd.uploadFile);
    webCommon.initICheck();
    appHumanAdd.initUI();
    $('#hname').focus();
});

var appHumanAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appHumanAdd.addIsClick==false) return false;
		var hname=$('#hname').val();
		var hdescription=$('#hdescription').val();
		var type1=$('#htype').select2('val');
		var pic=$('#pic').val();
		
		var sex=$('input[name="sex"]:checked').val();
		var ishot=$('input[name="ishot"]:checked').val();
		var iscommend=$('input[name="iscommend"]:checked').val();
		
		if(hname.length<2){
			toastr.error('姓名不能为空');
			$('#hname').focus();
			return false;
		}
		
		if(hdescription.length<2){
			toastr.error('描述不能为空');
			$('#hdescription').focus();
			return false;
		}
		
		if(pic.length<8){
			toastr.error('图片地址不能为空');
			$('#pic').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/apphumanadd';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			name: hname ,
			description: hdescription ,
			type1:type1,
			pic: pic ,
			sex: sex ,
			ishot: ishot ,
			iscommend:iscommend
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appHumanAdd.addIsClick=false;
		setTimeout(function() {	appHumanAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	uploadFile:function(){
		var formData = new FormData();
		var myFile1=$('#myFile')[0].files[0];
		var myType=7;
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
					  $('#pic').val(dt.msg)
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
        $('#myFile').on('change', function() {
            var fileName = $(this).val().split('\\').pop();
            $(this).next('.custom-file-label').addClass("selected").html(fileName);
        });
		$.post('/webapi/v1/apphumantypelist1',{token:$('#servertoken').val(),level:1},function (dt){
			  var tmpArray=new Array();
			  $.each(dt,function(index,el){
			    tmpArray.push({id:el.id,text:el.name});
			  });
			  $('#htype').select2({width: '60%',data: tmpArray});
		    },'json');
	}
});