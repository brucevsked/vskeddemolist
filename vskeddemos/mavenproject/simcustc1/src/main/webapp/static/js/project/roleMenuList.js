
$(function(){
	initNoSysRoleList();
	initHasSysRoleList();
	$.parser.parse();//重新加载样式
});

function initNoSysRoleList(){
	var smId=$('#smId').val();
	var myBasePath=basePath+'noSysRoleListMenu';
	
	$('#noSysRoleList').empty();
	
	$.post(myBasePath,{ smId: smId },function (dt){
		dt=JSON.parse(dt);
		$.each(dt,function (index,el){
			$('#noSysRoleList').append('<option value="'+el.SRID+'">'+el.SRNAME+'</option>');
		});
	});
	
}

function initHasSysRoleList(){
	var smId=$('#smId').val();
	var myBasePath=basePath+'hasSysRoleListMenu';
	
	$('#srIds').empty();
	
	$.post(myBasePath,{ smId: smId },function (dt){
		dt=JSON.parse(dt);
		$.each(dt,function (index,el){
			$('#srIds').append('<option value="'+el.SRID+'">'+el.SRNAME+'</option>');
		});
	});
}

function submitForm(){
	var smId=$('#smId').val();
	var srIds=getSelectValues('srIds');
	
	var myBasePath=$('#fm').attr("action");
	$.post(myBasePath,
			{
		smId: smId,
		srIds:srIds
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	userMenu();//重新加载菜单
		    	}
		    );
}