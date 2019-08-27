'use strict'

$(function(){
	$('#updateBt').on('click',appSiteMailPublish.update);
	appSiteMailPublish.initUI();
});

var appSiteMailPublish=new Object({
	updateIsClick:true,
	update:function(){
		if(appSiteMailPublish.updateIsClick==false) return false;
		
		var fid=$('#fid').val();
		var myUserIds=$('#myUserIds').val();
		var ids=myUserIds.join(',');
		
		var myBasePath='/webapi/v1/appsitemailpublish';
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			ids: ids 
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appSiteMailPublish.updateIsClick=false;
		setTimeout(function() {	appSiteMailPublish.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	    
	},
	initUI:function(){
		$.post('/webapi/v1/appsitemailpublishuser',{token:$('#servertoken').val(),fid:$('#fid').val()},function (myUser){
			//设置未选中的
			$.each(myUser,function(index1,tmpUser){
				$("#myUserIds").append('<option value="'+tmpUser.uid+'">'+tmpUser.username+','+tmpUser.phone+'</option>');
			});
			  
			$('#myUserIds').bootstrapDualListbox({
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

	}
});