'use strict'

$(function(){
	$('#updateBt').on('click',appAdvertUpdate.update);
	$('#uploadFile1Bt').on('click',appAdvertUpdate.uploadFile);
	appAdvertUpdate.initUI();
    $('#avname').focus();
});

var appAdvertUpdate=new Object({
	updateIsClick:true,
	oldSelectedOptiont1:null,
	update:function(){
		if(appAdvertUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
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
		
		var myBasePath='/webapi/v1/appadvertupdate';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
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
		
		appAdvertUpdate.updateIsClick=false;
		setTimeout(function() {	appAdvertUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
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
				  var tmpDt={id:el.id,text:el.name};
			      tmpArray.push(tmpDt);
			      if(tmpDt.id==$('#oldType1').val()){
			    	  appAdvertUpdate.oldSelectedOptiont1=tmpDt;
			      }
			  });
			  $('#type1').select2({width: '60%',data: tmpArray});
			  if(appAdvertUpdate.oldSelectedOptiont1!=null){
				  $('#type1').val(appAdvertUpdate.oldSelectedOptiont1.id,appAdvertUpdate.oldSelectedOptiont1.text).trigger("change"); 
			  }	
		    },'json');
		$('#targettype').select2({width: '60%'});
		var tmpSelectOption2=null;
		$.each($('#targettype option'),function (index,el){
			if(el.value==$('#oldTargetType').val()){
				tmpSelectOption2=el;
			}
		});
		if(tmpSelectOption2!=null){
			$('#targettype').val(tmpSelectOption2.value,tmpSelectOption2.text).trigger("change"); 
		}
	    $('#myFile').on('change', function() {
	        var fileName = $(this).val().split('\\').pop();
	        $(this).next('.custom-file-label').addClass("selected").html(fileName);
	    });
	}
	
});