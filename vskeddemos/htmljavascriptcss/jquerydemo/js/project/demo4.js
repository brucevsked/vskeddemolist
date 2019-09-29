$(function(){
	
});

function getSelCou(){
	var couName=$("input[name='country']:checked").val();
	console.log(couName);
}

function getSelC1(){
	var myR1=[];
	$("input[name='c1']:checked").each(function(i,o){
		myR1.push($(o).val());
	});
	console.log(myR1);
}