'use strict'

$(function(){
	$('#addBt').on('click',appModuleTypeAdd.add);
    $('#moduleTypeName').focus();
    webCommon.initICheck();
});

var appModuleTypeAdd=new Object({
	addIsClick:true,
	add:function(){
		
		if(appModuleTypeAdd.addIsClick==false) return false;
		
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
		
		var myBasePath='/webapi/v1/appmoduletypeadd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
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
		
		appModuleTypeAdd.addIsClick=false;
		setTimeout(function() {	appModuleTypeAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	}
});