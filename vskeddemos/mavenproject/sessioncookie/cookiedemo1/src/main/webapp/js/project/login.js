

$(function(){
	var userName=$.cookie('myCookieA1userName');
	var userPass=$.cookie('myCookieA1userPass');
	console.log(userName)
	console.log(userPass)
	if(userName!='null' && userPass!='null' && userName!=undefined && userPass!=undefined){
		$('#userName').val(userName);
		$('#userPass').val(userPass);
		$('#fm1').submit();
	}

});
