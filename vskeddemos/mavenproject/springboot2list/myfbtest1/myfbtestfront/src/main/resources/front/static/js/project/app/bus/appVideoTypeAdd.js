'use strict'

$(function(){
	$('#addBt').on('click',appVideoTypeAdd.add);
    webCommon.initICheck();
    appVideoTypeAdd.initUI();
    $('#vtname').focus();
});

var appVideoTypeAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appVideoTypeAdd.addIsClick==false) return false;
		var leveltype=$('input[name="leveltype"]:checked').val();
		var parenttype=$('#parenttype').select2('val');
		var vtname=$('#vtname').val();
		var vtdescription=$('#vtdescription').val();
		
		if(leveltype==2 && parenttype==null){
			toastr.error('1级分类不能为空');
			return false;
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
		
		var myBasePath='/webapi/v1/appvideotypeadd';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
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
		appVideoTypeAdd.addIsClick=false;
		setTimeout(function() {	appVideoTypeAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	},
	initUI:function(){
		$.post('/webapi/v1/appvideotypelistbylevel',{token:$('#servertoken').val(),level:1},function (dt){
			  var tmpArray=new Array();
			  $.each(dt,function(index,el){
			    tmpArray.push({id:el.id,text:el.name});
			  });
			  $('#parenttype').select2({width: '60%',data: tmpArray});
		    },'json');
		
		$('#myParentLevelDiv').hide();
		
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