'use strict'

var basePath='http://127.0.0.1:8080/htmltemplate/'; //tomcat

$(function(){
  
 //项目主类用来引入其他公用脚本

});

var mainjs=new Object({
    initFileList: function(){
      
    console.log('-------------start mainjs script load-----------------');
        
    //以下ajax可以复制多个来引入公用js
    //方案1
    //$.getScript( basePath+'js/lib/toastr/toastr.min.js');
    //方案2     
	  $.ajax({
	    type:'post',//加载方式post
		  async: false,//使用同步的方式,true为异步方式
		  //crossDomain: true,//跨域支持 本地运行时需要解开
		  cache:false, //缓存
		  url : basePath+'js/lib/toastr/toastr.min.js',//载入脚本路径 正式时需加basePath
	    dataType: 'script',
	    scriptCharset:'utf-8'
		});
		
		console.log('-------------end mainjs script load-----------------');		
      
    }
});

//不要移动这句位置
mainjs.initFileList();


