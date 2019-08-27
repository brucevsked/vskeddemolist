'use strict'

$(function(){
	$('#updateBt').on('click',appModuleTypeUpdate.update);
	appModuleTypeUpdate.initUI();
    webCommon.initICheck();
    $('#moduleTypeName').focus();
});

var appModuleTypeUpdate=new Object({
	updateIsClick:true,
	oldSelectedOption:null,
	update:function(){
		if(appModuleTypeUpdate.updateIsClick==false) return false;
		var fid=$('#fid').val();
		var moduleTypeName=$('#moduleTypeName').val();
		var description=$('#moduleTypeDescript').val();
		var seq=$('#moduleTypeSeq').val();
		var moduleTypeState=$('input[name="moduleTypeState"]:checked').val();
		
		if(moduleTypeName.length<2){
			toastr.error('名称不能为空');
			$('#moduleTypeName').focus();
			return false;
		}
		if(description.length<=0){
			toastr.error('描述不能为空');
			$('#vpdays').focus();
			return false;
		}
		if(seq.length<=0){
			toastr.error('序列不能为空');
			$('#moduleTypeSeq').focus();
			return false;
		}
		
		var myBasePath='/webapi/v1/appmoduletypeupdate';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			name: moduleTypeName ,
			description: description ,
			seq:seq,
			parentid:-1,
			state:moduleTypeState
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appModuleTypeUpdate.updateIsClick=false;
		setTimeout(function() {	appModuleTypeUpdate.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
	}
});