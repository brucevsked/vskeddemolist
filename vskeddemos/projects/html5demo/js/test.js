
	console.log('-----文件列表-----')
  document.querySelector('#testf1').onchange = function() {
  	console.log(this.files);
  	var fileList=this.files;
  	for(i=0;i<fileList.length;i++){
  		console.log(fileList[i])
  		console.log(fileList[i].name)
  	}

  };
  
function t1(){
  var fileList=document.querySelector('#testf1').files;
  for(i=0;i<fileList.length;i++){
    console.log(fileList[i])
    var file=fileList[i];
    var reader = new FileReader();
    //文本编码要为utf-8如果不是记事本打开后另存下
    reader.readAsText(file);
    reader.onload = function(f){
      console.log('---------'+file.name+'------------')
      var curResult=this.result;
      console.log(curResult);
    }//end onload
    
  }//end for i
}//end t1