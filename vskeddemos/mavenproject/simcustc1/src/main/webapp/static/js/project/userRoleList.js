
$(function(){
	initNoSysRoleList();
	initHasSysRoleList();
	$.parser.parse();//重新加载样式
});

function initNoSysRoleList(){
	var suId=$('#suId').val();
	var myBasePath=basePath+'noSysRoleList';
	
	$('#noSysRoleList').empty();
	
	$.post(myBasePath,{ suId: suId },function (dt){
		dt=JSON.parse(dt);
		$.each(dt,function (index,el){
			$('#noSysRoleList').append('<option value="'+el.SRID+'">'+el.SRNAME+'</option>');
		});
	});
	
}

function initHasSysRoleList(){
	var suId=$('#suId').val();
	var myBasePath=basePath+'hasSysRoleList';
	
	$('#srIds').empty();
	
	$.post(myBasePath,{ suId: suId },function (dt){
		dt=JSON.parse(dt);
		$.each(dt,function (index,el){
			$('#srIds').append('<option value="'+el.SRID+'">'+el.SRNAME+'</option>');
		});
	});
}

function submitForm(){
	var suId=$('#suId').val();
	var srIds=getSelectValues('srIds');
	
	var myBasePath=$('#fm').attr("action");
	$.post(myBasePath,
			{
		suId: suId,
		srIds:srIds
		    },function (dt){
		    	toastr.info(dt, '添加结果');
		    	}
		    );
}