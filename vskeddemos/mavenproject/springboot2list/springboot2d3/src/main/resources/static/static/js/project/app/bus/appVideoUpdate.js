'use strict'

$(function(){
	$('#updateBt').on('click',appVideoUpdate.update);
	$('#uploadFile1Bt').on('click',appVideoUpdate.uploadFile);
    webCommon.initICheck();
    appVideoUpdate.initUI();
    $('#vtname').focus();
});

var appVideoUpdate=new Object({
	updateIsClick:true,
	oldSelectedOptiont1:null,
	oldSelectedOptiont2:null,
	update:function(){
		if(appVideoUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var type1=$('#type1').select2('val');
		var type2=$('#type2').select2('val');
		var vname=$('#vname').val();
		var vdescription=$('#vdescription').val();
		var price=$('#price').val();
		var coverurls=$('#coverurls').val();
		var isprice=$('input[name="isprice"]:checked').val();
		var ishot=$('input[name="ishot"]:checked').val();
		var iscommend=$('input[name="iscommend"]:checked').val();
		
		if(isprice==1 && price.length<=0){
			toastr.error('收费影片价格不能为空');
			return false;
		}
		
		if(isprice==0){
			price=0;
		}
		
		if(vname.length<2){
			toastr.error('名称不能为空');
			$('#vname').focus();
			return false;
		}
		if(vdescription.length<2){
			toastr.error('描述不能为空');
			$('#vdescription').focus();
			return false;
		}
		if(coverurls.length<2){
			toastr.error('封面图片地址不能为空');
			$('#coverurls').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appvideoupdate';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			type1: type1 ,
			type2: type2 ,
			name: vname ,
			description: vdescription ,
			price: price ,
			coverurls: coverurls ,
			ishot: ishot ,
			iscommend: iscommend ,
			isprice: isprice 
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appVideoUpdate.updateIsClick=false;
		setTimeout(function() {	appVideoUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	},
	uploadFile:function(){
		var formData = new FormData();
		var myFile1=$('#myFile')[0].files[0];
		var myType=6;
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
					  $('#coverurls').val(dt.msg)
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
		$.post('/webapi/v1/appvideotypelistbylevel',{token:$('#servertoken').val(),level:1},function (dt){
			  var tmpArray=new Array();
			  $.each(dt,function(index,el){
				  var tmpDt={id:el.id,text:el.name};
			      tmpArray.push(tmpDt);
			      if(tmpDt.id==$('#oldType1').val()){
			    	  appVideoUpdate.oldSelectedOptiont1=tmpDt;
			      }
			  });
			  $('#type1').select2({width: '60%',data: tmpArray});
			  if(appVideoUpdate.oldSelectedOptiont1!=null){
				  $('#type1').val(appVideoUpdate.oldSelectedOptiont1.id,appVideoUpdate.oldSelectedOptiont1.text).trigger("change"); 
			  }			  
		    },'json');
		$.post('/webapi/v1/appvideotypelistbylevel',{token:$('#servertoken').val(),level:2},function (dt){
			  var tmpArray=new Array();
			  $.each(dt,function(index,el){
				  var tmpDt={id:el.id,text:el.name};
			      tmpArray.push(tmpDt);
			      if(tmpDt.id==$('#oldType2').val()){
			    	  appVideoUpdate.oldSelectedOptiont2=tmpDt;
			      }
			  });
			  $('#type2').select2({width: '60%',data: tmpArray});
			  if(appVideoUpdate.oldSelectedOptiont2!=null){
				  $('#type2').val(appVideoUpdate.oldSelectedOptiont2.id,appVideoUpdate.oldSelectedOptiont2.text).trigger("change"); 
			  }			  
		    },'json');
		var isprice=$('input[name="isprice"]:checked').val();
		
		if(isprice==0){
			$('#myPriceDiv').hide();
		}else{
			$('#myPriceDiv').show();
		}
		$('input[name="isprice"]').on('ifChecked', function(event){
			  var obj=$(this);
			  if(obj.val()==0){
				  $('#myPriceDiv').hide();
				  $('#price').val('0');
			  }else{
				  $('#myPriceDiv').show();
			  }
		});

	}
});