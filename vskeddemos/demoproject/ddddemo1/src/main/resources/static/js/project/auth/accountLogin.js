"use strict"

var accountLogin=new Object({
    setTitle:function(){
        //设置标题
        $("title").html("老衲图书借阅系统-登录");
    },
    loginValidate:function(accountInfo){
        //验证
        if(accountInfo==null || accountInfo.name==null || accountInfo.password==null ){
            alert("缺少账户信息或账户名或密码参数");
            return false;
        }

        if(common.trim(accountInfo.name)==""){
            alert("账户名称不能为空");
            $("#accountName").focus();
            return false;
        }
        if(common.trim(accountInfo.password)==""){
            alert("账户密码不能为空");
            $("#accountPassword").focus();
            return false;
        }
    },
    toLogin:function(){
        var accountName=$("#accountName").val();
        var accountPassword=$("#accountPassword").val();
        var account={"name":accountName,"password":accountPassword};
        //登录验证
        accountLogin.loginValidate(account);

        var accountLoginUrl=common.getAPIPath("session");
        $.post(accountLoginUrl,account,function (serverResponseData){
            console.log(serverResponseData);
            common.serverResponseDataValidate(serverResponseData);//验证响应数据
            if(serverResponseData.code!="0000"){
                //登录失败处理
                alert(serverResponseData.msg);
            }else{
                //登录成功处理
                var frontPageUrl="index.html";
                $(location).prop('href', common.jumpPage(frontPageUrl));
            }
        },"json");

    },
    clean:function(){
        $("#accountName").val("");
        $("#accountPassword").val("");
        $("#accountName").focus();
    },
    initUI:function(){
        //界面初始化
        accountLogin.setTitle();
        $("#accountLoginBt").on("click", accountLogin.toLogin);
        $("#cleanBt").on("click", accountLogin.clean);
        $("#accountName").focus();

    }
});

accountLogin.initUI();