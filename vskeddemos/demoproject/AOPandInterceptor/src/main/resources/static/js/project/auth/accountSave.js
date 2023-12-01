"use strict"

var accountSave=new Object({
    setTitle:function(){
        // 设置标题
        $("title").html("老衲图书借阅系统-创建账户");
    },

    initUI:function(){
        //界面初始化
        accountSave.setTitle();
        common.checkLogin();
    }
});

accountSave.initUI();