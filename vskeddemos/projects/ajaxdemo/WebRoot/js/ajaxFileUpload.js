

$(function(){
	$('#uname').focus();
});

function uploadFile(myUrl){
	var fm=$('#myFm');
	var options={
			url:myUrl,
			type:'post',
			data:{'uname':$('#uname').val()},
			success:function(dt){
				$('#resultA1').html(dt);
			}
	}
	fm.ajaxSubmit(options);
}