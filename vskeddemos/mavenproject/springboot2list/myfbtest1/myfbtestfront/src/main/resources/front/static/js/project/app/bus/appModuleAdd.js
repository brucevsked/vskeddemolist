'use strict'

$(function(){
	$('#addBt').on('click',appModuleAdd.add);
    webCommon.initICheck();
    appModuleAdd.initUI();
    $('#moduleName').focus();
});

var appModuleAdd=new Object({
	addIsClick:true,
	add:function(){
		if(appModuleAdd.addIsClick==false) return false;
		var appModuleTypeId=$('#appModuleTypeId').val();
		var moduleName=$('#moduleName').val();
		var moduleCode=$('#moduleCode').val();
		var moduleStyle=$('#moduleStyle').val();
		var api=$('#api').val();
		var tbname=$('#tbname').val();
		var tbparam=$('#tbparam').val();
		var seq=$('#seq').val();
		var state=$('input[name="state"]:checked').val();
		var headviewstate=$('input[name="headviewstate"]:checked').val();
		
		if(moduleName.length<2){
			toastr.error('模块名称不能为空');
			$('#moduleName').focus();
			return false;
		}
		
		if(tbparam.length<2){
			toastr.error('查询参数不能为空');
			$('#tbparam').focus();
			return false;
		}
		if(seq.length<=0){
			toastr.error('模块序列不能为空');
			$('#seq').focus();
			return false;
		}
		var myBasePath='/webapi/v1/appmoduleadd';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			type: appModuleTypeId ,
			name: moduleName ,
			code: moduleCode ,
			style: moduleStyle ,
			api: api ,
			tbname: tbname ,
			tbparam: tbparam ,
			seq: seq ,
			state: state ,
			headviewstate:headviewstate
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		appModuleAdd.addIsClick=false;
		setTimeout(function() {	appModuleAdd.addIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	},
	initUI:function(){
		
		$.post('/webapi/v1/appmoduletypelistdata',{	token:$('#servertoken').val()},function (dt){
			$.each(dt,function (myIndex,myEl){
				$("#appModuleTypeId").append('<option value="'+myEl.id+'">'+myEl.name+'</option>');
			});
	    },'json');
		
		$('#bannerModelBt').on('click',function(){
			$('#moduleName').val('banner001');
			$('#moduleCode').val('banner');
			$('#moduleStyle').val('banner01');
			$('#api').val('api/v1/appbanner');
			$('#tbname').val('appBannerT');
			$('#tbparam').val('type=1');
			
			$('#paramExt1').html('<select class="form-control" id="bannerTypeExt1">');//1
			$.post('/webapi/v1/appbannertypelistdata',{token:$('#servertoken').val()},function (dt){
				var tmpArray=new Array();
				$.each(dt,function(index,el){
					tmpArray.push({id:el.id,text:el.name});
				});
				$('#bannerTypeExt1').select2({width: '50%',data: tmpArray});
			},'json');//2
			
			$('#bannerTypeExt1').on('select2:select',function(e){
				 $('#tbparam').val('type='+$('#bannerTypeExt1').val());
		    });//3
			
		});
		$('#videoHotModelBt').on('click',function(){
			$('#moduleName').val('Movie001');
			$('#moduleCode').val('MovieClass');
			$('#moduleStyle').val('MovieClass01');
			$('#api').val('api/v1/appvideoinfolist');
			$('#tbname').val('appVideoInfoT');
			$('#tbparam').val('ishot=1&start=1&length=4');
			$('#paramExt1').html('');
		});
		
		$('#humanCommandModelBt').on('click',function(){
			$('#moduleName').val('StarLike001');
			$('#moduleCode').val('StarLike');
			$('#moduleStyle').val('StarLike01');
			$('#api').val('api/v1/apphumaninfolist');
			$('#tbname').val('appHumanInfoT');
			$('#tbparam').val('iscommend=1&start=1&length=8');
			$('#paramExt1').html('');
		});
		$('#humanCommandModel2Bt').on('click',function(){
			$('#moduleName').val('StarLike002');
			$('#moduleCode').val('StarLike');
			$('#moduleStyle').val('StarLike02');
			$('#api').val('api/v1/apphumaninfolist');
			$('#tbname').val('appHumanInfoT');
			$('#tbparam').val('iscommend=1&start=1&length=1');
			$('#paramExt1').html('');
		});
		$('#humanCommandModel3Bt').on('click',function(){
			$('#moduleName').val('StarLike003');
			$('#moduleCode').val('StarLike');
			$('#moduleStyle').val('StarLike03');
			$('#api').val('api/v1/apphumaninfolist');
			$('#tbname').val('appHumanInfoT');
			$('#tbparam').val('iscommend=1&start=1&length=1');
			$('#paramExt1').html('');
		});
		
		$('#advertModelBt').on('click',function(){
			$('#moduleName').val('ad001');
			$('#moduleCode').val('ad');
			$('#moduleStyle').val('ad01');
			$('#api').val('api/v1/appadvertbytype1');
			$('#tbname').val('appAdvertInfoT');
			$('#tbparam').val('type1=2');
			
			$('#paramExt1').html('<select class="form-control" id="advertTypeExt1">');//1
			$.post('/webapi/v1/appadverttypelistdata',{token:$('#servertoken').val()},function (dt){
				var tmpArray=new Array();
				$.each(dt,function(index,el){
					tmpArray.push({id:el.id,text:el.name});
				});
				$('#advertTypeExt1').select2({width: '50%',data: tmpArray});
			},'json');//2
			
			$('#advertTypeExt1').on('select2:select',function(e){
				 $('#tbparam').val('type1='+$('#advertTypeExt1').val());
		    });//3
		});
		
		$('#videoCommandModelBt').on('click',function(){
			$('#moduleName').val('Recommend001');
			$('#moduleCode').val('Recommend');
			$('#moduleStyle').val('Recommend01');
			$('#api').val('api/v1/appvideoinfolist');
			$('#tbname').val('appVideoInfoT');
			$('#tbparam').val('iscommend=1&start=1&length=4');
			$('#paramExt1').html('');
		});
		$('#videoCommandModel2Bt').on('click',function(){
			$('#moduleName').val('Recommend002');
			$('#moduleCode').val('Recommend');
			$('#moduleStyle').val('Recommend02');
			$('#api').val('api/v1/appvideoinfolist');
			$('#tbname').val('appVideoInfoT');
			$('#tbparam').val('iscommend=1&start=1&length=4');
			$('#paramExt1').html('');
		});
		
		$('#videoTypeModelBt').on('click',function(){
			$('#moduleName').val('Movie001');
			$('#moduleCode').val('MovieClass');
			$('#moduleStyle').val('MovieClass01');
			$('#api').val('api/v1/appvideoinfolist');
			$('#tbname').val('appVideoInfoT');
			$('#tbparam').val('type2=20002&start=1&length=4');
			$('#paramExt1').html('<select class="form-control" id="videoTypeExt1">');//1
			$.post('/webapi/v1/appvideotypelistbylevel',{token:$('#servertoken').val(),level:2},function (dt){
				var tmpArray=new Array();
				$.each(dt,function(index,el){
					tmpArray.push({id:el.id,text:el.name});
				});
				$('#videoTypeExt1').select2({width: '50%',data: tmpArray});
			},'json');//2
			
			$('#videoTypeExt1').on('select2:select',function(e){
				 $('#tbparam').val('type2='+$('#videoTypeExt1').val()+'&start=1&length=4');
		    });//3
		});
	}
});