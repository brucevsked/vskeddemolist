
function getDeskImg(){
	var myBasePath=document.getElementsByTagName('base')[0].href;
	myBasePath+='desk/procdesk.jsp';
	$.post(myBasePath,{ cds: new Date().getTime() },function (dt){
		$('#currentScreenVsk').attr('src',dt);
	});
}

function procRun(){
	if($('#runStateBt').html()=='开始'){
		$('#runStateBt').html('停止');
		runStateA1=setInterval(function(){getDeskImg()},1500);
	}else{
		$('#runStateBt').html('开始');
		clearInterval(runStateA1);
	}
}