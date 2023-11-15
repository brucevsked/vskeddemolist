"use strict"

var index=new Object({
    isDebug:true,
    setTitle:function(){
        $("title").html("老衲图书借阅系统-工作台");
    },
    accountList:function (){
        var frontPageUrl="auth/accountList.html";
        common.loadPage(frontPageUrl);
    },
    accountSave:function (){
        var frontPageUrl="auth/accountSave.html";
        common.loadPage(frontPageUrl);
    },
    getAccountInfo:function(){
        var accountDataUrl=common.getAPIPath("account");
        var account=common.getAccount();
        if(index.isDebug){
            console.log(account);
        }
        var accountId=account.accountId;

        if(index.isDebug){
            console.log(accountId);
        }
        $.get(accountDataUrl,{"accountId":accountId},function(serverResponseData){
            if(index.isDebug){
                console.log(serverResponseData);
            }

            var serverResponseDataStr=serverResponseData;
            var respJson=common.stringToJson(serverResponseDataStr);
            if(index.isDebug){
                console.log(respJson);
            }

            if(respJson.code=="0000"){
                $("#accountSpan").html("恭喜您，登录成功。"+respJson.data.accountName);
            }else{
                alert(respJson.msg);
            }

        });
    },
    logout:function(){
        if(index.isDebug){
            console.log(common.sessionStorageGet(common.sessionStorageName));
            console.log(common.localStorageGet(common.localStorageName));
        }

        var sessionObject=common.localStorageGet(common.localStorageName);

        if(index.isDebug){
            console.log(sessionObject);
        }

        if(sessionObject==null){
            alert("非法注销，请检查是否登录");
            common.toLoginPage();
            return false;
        }

        var sessionId=common.jsonToObject(sessionObject).sessionId;

        if(index.isDebug){
            console.log(sessionId);
        }

        if(sessionId==null){
            alert("非法注销，请检查是否登录");
            common.toLoginPage();
            return false;
        }

        var accountLogoutUrl=common.getAPIPath("session");
        $.ajax({
            type:'delete',
            url :accountLogoutUrl,
            data:{"sessionId":sessionId},
            success:function (serverResponseData){
                console.log(serverResponseData);
                if(serverResponseData.code!="0000"){
                    //注销失败处理
                    alert(serverResponseData.msg);
                }else{
                    //注销成功处理
                    //将sessionStorage中数据移除
                    common.sessionStorageRemove(common.sessionStorageName);
                    //将localStorage中中数据移除
                    common.localStorageRemove(common.localStorageName);

                    var frontPageUrl="auth/accountLogin.html";
                    $(location).prop('href', common.jumpPage(frontPageUrl));
                }
            },
            dataType: 'json'
        });

    },
    initUI:function(){
        index.setTitle();
        common.checkLogin();
        index.getAccountInfo();
        $("#logoutBt").on("click", index.logout);
        $("#accountListBt").on("click", index.accountList);
        $("#accountSaveBt").on("click", index.accountSave);

    }
});

index.initUI();