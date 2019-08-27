'use strict'

$(function(){
	$('#updateBt').on('click',appVideoStoreUrlBindBind.update);
	appVideoStoreUrlBindBind.initUI();
});

var appVideoStoreUrlBindBind=new Object({
	updateIsClick:true,
	serverGroup:null,
	localCount:0,
	update:function(){
		if(appVideoStoreUrlBindBind.updateIsClick==false) return false;
		
		var fid=$('#fid').val();
		var localUrls=$('input[name="localAddr"]');
		var localGroups=$('select[name="groupName"]');
		var remoteUrls=$('input[name="remoteAddr"]');
		var myLocalArray=new Array();
		var myRemoteArray=new Array();
		var myLocalGroupArray=new Array();
		
		$.each(localUrls,function(index,el){
			if(el.value.length<5){
				toastr.error('请填写地址后再绑定');
				el.focus();
				return false;
			}
			myLocalArray.push(el.value);
		});
		
		$.each(localGroups,function(index,el){
			myLocalGroupArray.push(el.value);
		});
		
		$.each(remoteUrls,function(index,el){
			if(el.value.length<5){
				toastr.error('请填写地址后再绑定');
				el.focus();
				return false;
			}
			myRemoteArray.push(el.value);
		});

		var myBasePath='/webapi/v1/appvideostoreurlbind';
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			localids: myLocalArray.join(','), 
			localgroups:myLocalGroupArray.join(','),
			remoteids: myRemoteArray.join(',') 
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appVideoStoreUrlBindBind.updateIsClick=false;
		setTimeout(function() {	appVideoStoreUrlBindBind.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	    
	},
	delVideoStoreUrl:function(obj){
		$(obj).parent().remove();
	},
	localVideoStoreUrlAdd:function(){
		var rs='';
		rs+='<div class="form-group row">';
		rs+='<select id="groupName'+appVideoStoreUrlBindBind.localCount+'" name="groupName"></select>';
		rs+='<input type="text" class="col-sm-5 form-control" name="localAddr" value="">';
		rs+='<button type="button" class="col-sm-1 btn btn-w-m btn-danger" onclick="appVideoStoreUrlBindBind.delVideoStoreUrl(this);">删除</button>';
		rs+='</div>';
		rs=$(rs);
		$('#localUrlDiv').append(rs);
		
		$('#groupName'+appVideoStoreUrlBindBind.localCount).select2({width: '20%',data: appVideoStoreUrlBindBind.serverGroup});
		
		appVideoStoreUrlBindBind.localCount=appVideoStoreUrlBindBind.localCount+1;

	},
	remoteVideoStoreUrlAdd:function(){
		var rs='';
		rs+='<div class="form-group row">';
		rs+='<input type="text" class="col-sm-7 form-control" name="remoteAddr" value="">';
		rs+='<button type="button" class="col-sm-2 btn btn-w-m btn-danger" onclick="appVideoStoreUrlBindBind.delVideoStoreUrl(this);">删除</button>';
		rs+='</div>';
		rs=$(rs);
		$('#remoteUrlDiv').append(rs);
	},
	initUI:function(){
		$.post('/webapi/v1/appservergrouplist',{token:$('#servertoken').val(),videoid:$('#fid').val()},function (dt){
			var rs='';
			var tmpGroupList=new Array();
			$.each(dt,function(index,el){
				tmpGroupList.push({id:el,text:el});
			});
			appVideoStoreUrlBindBind.serverGroup=tmpGroupList;
			
			$.post('/webapi/v1/getvideostoreurlbyvideoid',{token:$('#servertoken').val(),videoid:$('#fid').val()},function (dt){
				var rs='';
				$.each(dt,function(index,el){
					if(el.storetype==1){
						//TODO fixed to jquery append
						rs='';
						rs+='<div class="form-group row">';
						rs+='<select id="groupName'+appVideoStoreUrlBindBind.localCount+'" name="groupName"></select>';
						rs+='<input type="text" class="col-sm-7 form-control" name="localAddr" value="'+el.storeurls+'">';
						rs+='<button type="button" class="col-sm-2 btn btn-w-m btn-danger" onclick="appVideoStoreUrlBindBind.delVideoStoreUrl(this);">删除</button>';
						rs+='</div>';
						rs=$(rs);
						$('#localUrlDiv').append(rs);
						$('#groupName'+appVideoStoreUrlBindBind.localCount).select2({width: '20%',data: appVideoStoreUrlBindBind.serverGroup});
						
						$('#groupName'+appVideoStoreUrlBindBind.localCount).append('<option value="'+el.servergroup+'" selected>'+el.servergroup+'</option>');
						$('#groupName'+appVideoStoreUrlBindBind.localCount).trigger('change');
						
						appVideoStoreUrlBindBind.localCount=appVideoStoreUrlBindBind.localCount+1;
					}
					if(el.storetype==2){
						rs='';
						rs+='<div class="form-group row">';
						rs+='<input type="text" class="col-sm-7 form-control" name="remoteAddr" value="'+el.storeurls+'">';
						rs+='<button type="button" class="col-sm-2 btn btn-w-m btn-danger" onclick="appVideoStoreUrlBindBind.delVideoStoreUrl(this);">删除</button>';
						rs+='</div>';
						rs=$(rs);
						$('#remoteUrlDiv').append(rs);
					}
				});
			
			    },'json');
			
		},'json');

	}
});