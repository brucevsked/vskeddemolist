

function setMethod(tp){
	var m="POST";
	switch(tp){
	case 1: m="POST"; break;
	case 2: m="GET"; break;
	case 3: m="PUT"; break;
	case 4: m="DELETE"; break;
	default:m="POST";
	}
	
	document.getElementById("fm").method=m;
	document.getElementById("fm").submit();
}