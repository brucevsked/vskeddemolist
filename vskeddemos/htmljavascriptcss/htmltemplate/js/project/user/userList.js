'use strict'

$(function(){
  //模块专用类
  userList.initList();
  
  $('#userAddBt').on('click',userList.add);
});

var userList=new Object({
    initList: function(){
      console.log('this is user list');
      
    toastr.options = {
    closeButton: true,
    progressBar: true,
    showMethod: 'slideDown',
    timeOut: 4000
    };
    toastr.success('内容放在这里就好了<br>可以多放一些东西a', '用户列表加载成功了');
    
    
    },
    add:function(){
      $('#username').val('添加成功啦'+$('#username').val());
      
      common.initCommon();//调用通用工具类中方法处理
      
		  toastr.info('内容放在这里就好了<br>可以多放一些东西e', '标题显示这个5', {timeOut: 5000,
			closeButton : true,
			progressBar : true,
			showMethod : 'slideDown',
			positionClass : "toast-bottom-right"});
    }
});
