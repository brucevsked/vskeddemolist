'use strict'

$(function(){
	$('#updateBt').on('click',appRolePermissionBind.update);
	appRolePermissionBind.initUI();
});

var appRolePermissionBind=new Object({
	updateIsClick:true,
	update:function(){
		if(appRolePermissionBind.updateIsClick==false) return false;
		
		var fid=$('#fid').val();
		var permissionIds=$('#myPermissionIds').val();
		var myPermissionIds=permissionIds.join(',');
		
		var myBasePath='/webapi/v1/approlepermissionbind';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			myPermissionIds: myPermissionIds 
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appRolePermissionBind.updateIsClick=false;
		setTimeout(function() {	appRolePermissionBind.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	    
	},
	initUI:function(){
		$.post('/webapi/v1/approlepermissionnoselected',{token:$('#servertoken').val(),roleid:$('#fid').val()},function (dtnoselected){
			//设置未选中的
			$.each(dtnoselected,function(index1,elnoselected){
				$("#myPermissionIds").append('<option value="'+elnoselected.id+'">'+elnoselected.name+'</option>');
			});
			  
			$.post('/webapi/v1/approlepermissionselected',{token:$('#servertoken').val(),roleid:$('#fid').val()},function (dtselected){
				//设置已选中的
				$.each(dtselected,function(index2,elselected){
					$("#myPermissionIds").append('<option value="'+elselected.id+'" selected >'+elselected.name+'</option>');
			});
			
			$('#myPermissionIds').bootstrapDualListbox({
				nonSelectedListLabel: '未选中选项',
				selectedListLabel: '已经选中选项',
				showFilterInputs: true,
				filterTextClear: '清空过滤条件',
				filterPlaceHolder: '过滤条件',
				nonSelectedFilter: '',
				selectedFilter: '',
				moveOnSelect: false,
				moveAllLabel: '添加全部选项',
				moveSelectedLabel: '添加选中的选项',
				removeAllLabel: '移除全部选项',
				removeSelectedLabel: '移除选中选项',
				preserveSelectionOnMove: 'moved',
				helperSelectNamePostfix: '_ast',
				selectorMinimalHeight: 260,
				infoText: '共选中 {0} 项',
				infoTextFiltered: '从 {1} 项 筛选 {0} 项',
				infoTextEmpty: '列表为空',
				filterOnValues: false
			});
			  
		    },'json');
			  
      },'json');

	}
});