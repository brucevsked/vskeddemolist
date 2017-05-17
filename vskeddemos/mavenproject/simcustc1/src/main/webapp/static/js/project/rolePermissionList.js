
$(function(){
	initNoSysRoleList();
	initHasSysRoleList();
	$.parser.parse();//重新加载样式
});

function initNoSysRoleList(){
	var spId=$('#spId').val();
	var myBasePath=basePath+'noSysRoleListPermission';
	
	$('#noSysRoleList').empty();
	
	$.post(myBasePath,{ spId: spId },function (dt){
		dt=JSON.parse(dt);
		$.each(dt,function (index,el){
			$('#noSysRoleList').append('<option value="'+el.SRID+'">'+el.SRNAME+'</option>');
		});
	});
	
}

function initHasSysRoleList(){
	var spId=$('#spId').val();
	var myBasePath=basePath+'hasSysRoleListPermission';
	
	$('#srIds').empty();
	
	$.post(myBasePath,{ spId: spId },function (dt){
		dt=JSON.parse(dt);
		$.each(dt,function (index,el){
			$('#srIds').append('<option value="'+el.SRID+'">'+el.SRNAME+'</option>');
		});
	});
}

function submitForm(){
	var spId=$('#spId').val();
	var srIds=getSelectValues('srIds');
	
	var myBasePath=$('#fm').attr("action");
	$.post(myBasePath,
			{
		spId: spId,
		srIds:srIds
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}