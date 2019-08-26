'use strict'

$(function(){
	$('#updateBt').on('click',appHumanVideoInfoBind.update);
    appHumanVideoInfoBind.initUI();
});

var appHumanVideoInfoBind=new Object({
	updateIsClick:true,
	update:function(){
		if(appHumanVideoInfoBind.updateIsClick==false) return false;
		
		var fid=$('#fid').val();
		var humanIds=$('#myHumanIds').val();
		var myBasePath='/webapi/v1/apphumanvideoinfobind';
		var myHumanIds=humanIds.join(',');
		
		$.post(myBasePath,{
			token:$('#servertoken').val(),
			fid:fid,
			humanids: myHumanIds 
		},function (dt){
			  if('000000'==dt.code){
				  toastr.success(dt.msg);
			  }else{
				  toastr.error(dt.msg);
			  }
	    },'json');
		
		appHumanVideoInfoBind.updateIsClick=false;
		setTimeout(function() {	appHumanVideoInfoBind.updateIsClick = true;	}, 3000);//3秒内不可以重复点击
	    
	    
	},
	initUI:function(){
		$.post('/webapi/v1/getnoselectedforvideo',{token:$('#servertoken').val(),videoid:$('#fid').val()},function (dtnoselected){
			//设置未选中的
			$.each(dtnoselected,function(index1,elnoselected){
				$("#myHumanIds").append('<option value="'+elnoselected.id+'">'+elnoselected.name+'</option>');
			});
			  
			$.post('/webapi/v1/getselectedforvideo',{token:$('#servertoken').val(),videoid:$('#fid').val()},function (dtselected){
				//设置已选中的
				$.each(dtselected,function(index2,elselected){
					$("#myHumanIds").append('<option value="'+elselected.id+'" selected >'+elselected.name+'</option>');
			});
			
			$('#myHumanIds').bootstrapDualListbox({
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