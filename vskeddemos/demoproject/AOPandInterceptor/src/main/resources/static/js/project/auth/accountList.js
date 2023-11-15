"use strict"

var accountList=new Object({
    isDebug:true,
    setTitle:function(){
        // 设置标题
        $("title").html("老衲图书借阅系统-账户列表");
    },
    initAccountListData:function(){
        var accountListDataUrl=common.getAPIPath("accountsForBootStrapTable");

        $("#accountListTable").bootstrapTable({
            columns: [
                {
                    checkbox: true,
                    visible: true
                },{
                    field: "accountId",
                    title: "编号",
                    visible: true,
                    align: "center",
                    valign: "middle"
                }, {
                    field: "accountName",
                    title: "账户名"
                }],
            method: "get", //请求方式
            url: accountListDataUrl, //请求地址 数据格式为
            cache: false,  //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            queryParamsType:"",//必须带这个参数 不带这个会变成offet,limit模式请求
            queryParams:function(params){
                var myParams={
                    pageSize:params.pageSize,
                    pageNumber:params.pageNumber,
                    accountName:$("#accountName").val()
                };
                return myParams;

            },
            pagination: true,  //开启分页
            pageList:[3,5,10,20,25,30,35],
            paginationLoop:true, //到最后一页再点下一页时回到第一页
            pageNumber: 1, //起始页
            pageSize: 3, //一页显示多少条
            sidePagination: "server", //分页模式 server:服务端模式, client:客户端分页模式
            search: false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，意义不大
            clickToSelect: true,
            singleSelect : true //打开单选选项vsked
        });


    },
    query:function(){
        if(accountList.isDebug){
            console.log("let's query now");
        }
        $("#accountListTable").bootstrapTable("refresh");
    },
    initUI:function(){
        //界面初始化
        accountList.setTitle();
        common.checkLogin();
        accountList.initAccountListData();
        $("#queryBt").on("click", accountList.query);
    }
});

accountList.initUI();