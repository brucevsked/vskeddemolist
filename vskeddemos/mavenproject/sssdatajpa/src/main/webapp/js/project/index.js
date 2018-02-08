
var basePath=document.getElementsByTagName('base')[0].href;

function getUserList(){
	myBasePath=basePath+'user/getAllUser';
	$.post(myBasePath,{ },function (dt){
		console.log(dt)
		$('#myResult').html(dt);		
	});
};

