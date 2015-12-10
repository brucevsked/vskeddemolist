

function testPost0(myBasePath){
	myBasePath+='proc/proc1.jsp';
	$.post(myBasePath,{ myName: 'vsked' , myAge: 18 , loveGirl: true});
}

function testPost1(myBasePath){
	myBasePath+='proc/proc2.jsp';
	$.post(myBasePath,{ myName: $('#sMobile').val() });
}

function testPost2(myBasePath){
	myBasePath+='proc/proc3.jsp';
	$.post(myBasePath,{ myName: $('#sMobile').val() },function (dt){
		$('#tDecode').val(dt);		
	});
}

function testPost3(myBasePath){
	myBasePath+='proc/proc4.jsp';
	$.post(myBasePath,{ myName: $('#sMobile').val() },function (dt){
		$('#tDecode').val(dt);		
	},"html");
	//html,xml,json,text,script,jsonp
}

function testPost4(myBasePath){
	myBasePath+='proc/proc5.jsp';
	$.ajax({
		type:'post',
		url :myBasePath,
		data:{ myName: $('#sMobile').val() },
		success:function (dt){
		$('#tDecode').val(dt);		
	    },
	    dataType: 'html'
		});
	//html,xml,json,text,script,jsonp
}

