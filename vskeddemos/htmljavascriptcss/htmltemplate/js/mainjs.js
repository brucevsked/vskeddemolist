'use strict'

$(function(){
  
 //项目主类用来引入其他公用脚本

});

var mainjs=new Object({
    initFileList: function(){
      
    console.log('start mainjs script load');
    
    //以下ajax可以复制多个来引入公用js
	  $.ajax({
	    type:'post',//加载方式post
		  async: false,//使用同步的方式,true为异步方式
		  crossDomain: true,//跨域支持
		  url :'js/lib/toastr/toastr.min.js',//载入脚本路径 正式时需加basePath
	    dataType: 'script'
		});
		
		
      
    }
});

//不要移动这句位置
mainjs.initFileList();


