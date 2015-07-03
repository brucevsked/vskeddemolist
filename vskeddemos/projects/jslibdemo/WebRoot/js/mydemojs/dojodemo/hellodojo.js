
require(["dojo/dom", "dojo/domReady!"], 
    function(dom){
	
	var myButton = dom.byId("myBt1"),
    myDiv = dom.byId("myDiv1");
	
	myDiv.innerHTML = "Hello New World! by dojo1.9.3a01";
	
	myButton.innerHTML="ckishere";
	
});