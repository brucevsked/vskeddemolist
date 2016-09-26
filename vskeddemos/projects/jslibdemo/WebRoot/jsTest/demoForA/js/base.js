
var strHello='hello world!';
var ct=0;

ts();

function ts(){
	//sayHelloAlert();
	//sayHelloConsole();
	//sayHelloWrite();
	//createElementTest();
	
	var testJson=new jsonTest();
	//testJson.testObject();
	//testJson.testObjects();
}

function outPutV(){
	console.log('a003|'+arguments.length);

	if(arguments.length==1)console.log(arguments[0]);
	
	this.outPutJson=function(tmpObject){
		for(var tmpKey in tmpObject) 
		if(this.isJson(tmpObject[tmpKey])){
		 this.outPutJson(tmpObject[tmpKey]);
		}else{
			console.log('a001_a|'+tmpKey+'|'+tmpObject[tmpKey]+'|'+typeof(tmpObject[tmpKey]));
		}
	};
	this.isJson = function(obj){ 
		return typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length; 
	};
	
	if(arguments.length>=2){				
		if(arguments[0]==0){
			var tmpObject=arguments[1];
			this.outPutJson(tmpObject);
		}
		
	}//end if arguments length
	
}//end outPutV

function sayHelloAlert(){
	alert(strHello);
}

function sayHelloConsole(){
	console.log(strHello);
	console.debug(strHello);
	console.info(strHello);
	console.warn(strHello);
	console.error(strHello);
}

function sayHelloWrite(){
	document.write(strHello);
}

function createElementTest(){
var btn = document.createElement('button');
btn.innerText='click me'+ct++;
btn.onclick = function(){
	console.log(this.innerHTML);
	createElementTest();  
	};
document.body.appendChild(btn);	
}

function jsonTest(){
	
	this.testObject=function (){
		var tmpObject={'cname':'xmkj','cboy':true,'cgirl':18};
		new outPutV().outPutJson(tmpObject);
		console.log('a002|'+tmpObject.cname+'|'+tmpObject.cboy+'|'+tmpObject.cgirl);
	};
	this.testObjects=function(){
		var tmpObject={'d0':{'cname':'xmkj0','cboy':true,'cgirl':18},'d1':{'cname':'xmkj1','cboy':false,'cgirl':19},'d2':{'cname':'xmkj2','cboy':true,'cgirl':15}};
		
		new outPutV().outPutJson(tmpObject);
		new outPutV('---------------------------------------');
		new outPutV(0,tmpObject);
	};
}

