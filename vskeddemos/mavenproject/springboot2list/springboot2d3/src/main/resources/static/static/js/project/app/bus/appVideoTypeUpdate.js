'use strict'

$(function(){
	$('#updateBt').on('click',appVideoTypeUpdate.update);
    webCommon.initICheck();
    appVideoTypeUpdate.initUI();
    $('#vtname').focus();
});

var appVideoTypeUpdate=new Object({
	updateIsClick:true,
	oldSelectedOption:null,
	update:function(){
		if(appVideoTypeUpdate.updateIsClick==false) return false;
		var oldPid=$('#oldPid').val();
		var fid=$('#fid').val();
		var leveltype=$('input[name="leveltype"]:checked').val();
		var parenttype=$('#parenttype').select2('val');
		var vtname=$('#vtname').val();
		var vtdescription=$('#vtdescription').val();
		
		if(leveltype==2 && parenttype==null){
			toastr.error('1级分类不能为空');
			return false;
		}
		
		if(oldPid==1 && leveltype==1){
			parentid=oldPid;
		}
		
		if(vtname.length<2){
			toastr.error('类型名称不能为空');
			$('#vtname').focus();
			return false;
		}
		if(vtdescription.length<2){
			toastr.error('类型描述不能为空');
			$('#vtdescription').focus();
			return false;
		}
		
		var parentid=1;
		if(leveltype==2){
			parentid=parenttype;
		}
		
		var myBasePath='/webapi/v1/appvideotypeupdate';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			name: vtname ,
			description: vtdescription ,
			parentid: parentid ,
			level:leveltype
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appVideoTypeUpdate.updateIsClick=false;
		setTimeout(function() {	appVideoTypeUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
		$.post('/webapi/v1/appvideotypelistbylevel',{token:$('#servertoken').val(),level:1},function (dt){
			  var tmpArray=new Array();
			  $.each(dt,function(index,el){
				  var tmpDt={id:el.id,text:el.name};
			      tmpArray.push(tmpDt);
			      if(tmpDt.id==$('#oldPid').val()){
			    	  appVideoTypeUpdate.oldSelectedOption=tmpDt;
			      }
			  });
			  $('#parenttype').select2({width: '60%',data: tmpArray});
			  if(appVideoTypeUpdate.oldSelectedOption!=null){
				  $('#parenttype').val(appVideoTypeUpdate.oldSelectedOption.id,appVideoTypeUpdate.oldSelectedOption.text).trigger("change"); 
			  }			  
		    },'json');
		var leveltype=$('input[name="leveltype"]:checked').val();
		
		if(leveltype==1){
			$('#myParentLevelDiv').hide();
		}else{
			$('#myParentLevelDiv').show();
		}
		
		$('input[name="leveltype"]').on('ifChecked', function(event){
			  var obj=$(this);
			  if(obj.val()==1){
				  $('#myParentLevelDiv').hide();
			  }else{
				  $('#myParentLevelDiv').show();
			  }
		});

	}
});