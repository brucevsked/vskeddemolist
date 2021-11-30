$(function(){
	
});

function getSelCou(){
	var couName=$("input[name='country']:checked").val();
	console.log(couName);
}

function getSelC1(){
	var myR1=[];
	var checkBoxList=$("input[name='c1']:checked");
	$.each(checkBoxList,function(myIndex,myEl){
		// var curCk=$(myEl);
		// console.log(curCk.val()+"|"+curCk.attr("id")); //方案1
		myR1.push(myEl.value);
		console.log(myEl.value+"|"+myEl.id); //方案2
	});
	console.log(myR1);
}