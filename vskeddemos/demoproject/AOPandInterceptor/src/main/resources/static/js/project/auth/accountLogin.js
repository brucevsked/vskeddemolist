"use strict"

var accountLogin=new Object({
    setTitle:function(){
        //设置标题
        $("title").html("老衲图书借阅系统-账户登录");
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
            console.log(serverResponseData.data);

            common.serverResponseDataValidate(serverResponseData);//验证响应数据
            if(serverResponseData.code!="0000"){
                //登录失败处理
                if(serverResponseData.code=="0002"){
                    alert(serverResponseData.msg);
                    //已经登录处理
                    //{sessionId: "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6M…TkwfQ._Kc53Bc3WBm-FnupSKrMKI0B725l-vUUhY-U5jzRMe8", createTime: "2020-10-21 16:16:30.24", expireTime: "2020-10-22 16:16:30.24", accountId: "2"}
                    var respJsonData=common.objectToJson(serverResponseData.data);
                    //将响应数据保存到sessionStorage中
                    common.sessionStorageSave(common.sessionStorageName,respJsonData);
                    //将响应数据保存到localStorage中
                    common.localStorageSave(common.localStorageName,respJsonData);
                    var frontPageUrl="index.html";
                    $(location).prop('href', common.jumpPage(frontPageUrl));
                }else{
                    alert(serverResponseData.msg);
                }
            }else{
                //登录成功处理
                //{sessionId: "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6M…TkwfQ._Kc53Bc3WBm-FnupSKrMKI0B725l-vUUhY-U5jzRMe8", createTime: "2020-10-21 16:16:30.24", expireTime: "2020-10-22 16:16:30.24", accountId: "2"}
                var respJsonData=common.objectToJson(serverResponseData.data);
                //将响应数据保存到sessionStorage中
                common.sessionStorageSave(common.sessionStorageName,respJsonData);
                //将响应数据保存到localStorage中
                common.localStorageSave(common.localStorageName,respJsonData);
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

        common.cleanLoginInfo();//清空登录信息

        $("#accountName").focus();

    }
});

accountLogin.initUI();