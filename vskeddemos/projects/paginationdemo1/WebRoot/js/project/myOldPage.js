
function myOldPage(){
	if(arguments.length==0){
	}else if(arguments.length==1){
		var arg1=arguments[0];
		console.log('there has 0 arguements'+arg1)
	}else if(arguments.length==2){
		var arg1=arguments[0];
		var arg2=arguments[1];
		console.log('there has 0 arguements|'+arg1+'|'+arg2)
	}else{
		console.log(arguments)
	}
}
//TODO fixed here
myOldPage.prototype.tbName='';
myOldPage.prototype.formName='';

var myNewPage=new myOldPage();

function initMyOldPage(){
var firstPageElement = document.createElement('a');
firstPageElement.href='javascript:void(0);';
firstPageElement.onclick='dosubmit(,1)';

var myTbElement=document.getElementById(myOldPage.tbName);
insertAfter(firstPageElement,myTbElement);

};

function dosubmit(fmid,currentPage){
	document.getElementById("currentPage").value=currentPage;
	document.getElementById(fmid).submit();
}

function insertAfter(newEl, targetEl)
{
    var parentEl = targetEl.parentNode;
            
     if(parentEl.lastChild == targetEl){
           parentEl.appendChild(newEl);
      }else{
           parentEl.insertBefore(newEl,targetEl.nextSibling);
       }            
}