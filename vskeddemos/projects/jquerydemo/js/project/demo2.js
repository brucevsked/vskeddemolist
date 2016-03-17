

function selectAllTest(){
	$("body *").css("background-color","#B2E0FF");
}

function selectByIdTest(){
	var usNameOldValue=$('#usName').val();
	console.log(usNameOldValue);
	var usNameNewValue='you name is black jack cc';
	$('#usName').val(usNameNewValue);
}

function selectByClassTest () {
  console.log($(".myStyleA1").html());
  $(".myStyleA1").html('1'+$(".myStyleA1").html())
}

function selectByTagTest(){
  $("p").css("background-color","#FCE");
}

function selectByMutiClassTest(){
  $(".myStyleA3.myStyleA4").css("background-color","#F0F");
}

function selectTagFirstTest(){
	$("p:first").html('a'+$("p:first").html());
}

function selectTagLastTest(){
	$("p:last").html('b'+$("p:last").html());
}

function selectEvenTrTest(){
	$("tr:even").css("background-color","#2CC");
}

function selectOddTrTest(){
	$("tr:odd").css("background-color","#CCC");
}
