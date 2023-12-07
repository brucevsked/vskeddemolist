"use strict"

var index=new Object({
    setTitle:function(){
        $("title").html("老衲图书借阅系统-工作台");
    },
    initUI:function(){
        index.setTitle();

    }
});

index.initUI();