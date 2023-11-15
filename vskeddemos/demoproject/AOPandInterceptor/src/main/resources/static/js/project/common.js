"use strict"

var common=new Object({
    localStorageName:"sessionId_localStorage",
    sessionStorageName:"sessionId_sessionStorage",
    /**
     * 是否开启调试模式，开启时会在控制台输出变量值
     */
    isDebug:true,
    /**
     * 是否开启单元测试 true开启 false关闭
     */
    isTest:false,
    /**
     * 获取基础地址 如前台请求地址 后台请求地址
     * @returns {{frontPath: string, backPath: string}}
     */
    getBasePath:function(){
        return {
            "frontPath":"http://127.0.0.1:8181/",
            "backPath":"http://127.0.0.1:8181/"
        };
    },
    objectToJson:function (objectData){
        if(common.isDebug){
            console.log(objectData);
        }
        return JSON.stringify(objectData);
    },
    stringToJson:function(stringData){
        if(common.isDebug){
            console.log(stringData);
        }
        return $.parseJSON(stringData);
    },
    jsonToObject:function(jsonData){
        if(common.isDebug){
            console.log(jsonData);
        }
        return JSON.parse(jsonData);
    },
    /**
     * 任何向后台请求都要调用此方法
     * 获取后台API全地址
     * 传入示例account/name
     * 返回http://127.0.0.1:8181/account/name
     * @param apiPath
     */
    getAPIPath:function(apiPath){
        if(common.isDebug){
            console.log(apiPath);
        }
        return common.getBasePath().backPath+apiPath;
    },
    /**
     * 去空格
     * @param str
     * @returns {*}
     */
    trim:function(str){
        if(common.isDebug){
            console.log(str);
        }
        return str.replace(/\s/g,"");
    },
    /**
     * 跳转页面
     * @param pageUrl
     */
    jumpPage:function(pageUrl){
        if(common.isDebug){
            console.log(pageUrl);
            console.log(common.getBasePath().frontPath+pageUrl);
        }
        $(location).prop('href', common.getBasePath().frontPath+pageUrl);
    },
    /**
     * 载入指定url到mainContent层内
     * @param pageUrl
     * @param data
     * @param callback
     */
    loadPage:function(pageUrl,data,callback){
        if(common.isDebug){
            console.log(pageUrl);
            console.log(data);
            console.log(common.getBasePath().frontPath+pageUrl);
        }
        $('#mainDiv').load(common.getBasePath().frontPath+pageUrl,data,callback);
    },
    /**
     * 服务端响应数据验证
     * 响应数据格式为
     * {
     *     code:"响应编码，必须有",
     *     msg:"响应消息，必须有",
     *     data:"响应数据，可有可无"
     * }
     */
    serverResponseDataValidate(serverResponseData){
        if(common.isDebug){
            console.log(serverResponseData);
        }
        if(serverResponseData==null || serverResponseData==undefined){
            alert("接收响应数据失败，请联系管理员");
            return false;
        }

        if(serverResponseData.code==null || serverResponseData.code==undefined ||serverResponseData.msg==null || serverResponseData.msg==undefined){
            alert("响应数据结构异常，请联系管理员");
            return false;
        }

    },
    checkLogin:function (){
        var sessionObject=common.localStorageGet(common.localStorageName);
        if(common.isDebug){
            console.log(sessionObject);
        }
        if(sessionObject==null){
            alert("非法访问，请检查是否登录");
            common.toLoginPage();
        }
    },
    getSessionId:function(){
        common.checkLogin();

        var sessionObject=common.localStorageGet(common.localStorageName);
        if(common.isDebug){
            console.log(sessionObject);
        }

        var sessionId=common.jsonToObject(sessionObject).sessionId;
        if(common.isDebug){
            console.log(sessionId);
        }
        return sessionId;
    },
    getAccount:function(){
        common.checkLogin();

        var sessionObject=common.localStorageGet(common.localStorageName);
        if(common.isDebug){
            console.log(sessionObject);
        }

        var account=common.jsonToObject(sessionObject).account;
        if(common.isDebug){
            console.log(account);
        }
        return account;
    },
    cleanLoginInfo:function(){
        //将sessionStorage中数据移除
        common.sessionStorageRemove(common.sessionStorageName);
        //将localStorage中中数据移除
        common.localStorageRemove(common.localStorageName);
    },
    toLoginPage:function (){
        var frontPageUrl="auth/accountLogin.html";
        if(common.isDebug){
            console.log(frontPageUrl);
        }
        $(location).prop('href', common.jumpPage(frontPageUrl));
    },
    localStorageRemove:function(itemName){
        if(common.isDebug){
            console.log(itemName);
        }
        window.localStorage.removeItem(itemName);
    },
    localStorageGet:function(itemName){
        if(common.isDebug){
            console.log(itemName);
        }
        return window.localStorage.getItem(itemName);
    },
    localStorageSave:function(itemName,itemValue){
        if(common.isDebug){
            console.log(itemName);
            console.log(itemValue);
        }
        window.localStorage.setItem(itemName, itemValue);
    },
    sessionStorageRemove:function(itemName){
        if(common.isDebug){
            console.log(itemName);
        }
        window.sessionStorage.removeItem(itemName);
    },
    sessionStorageGet:function(itemName){
        if(common.isDebug){
            console.log(itemName);
        }
        return window.sessionStorage.getItem(itemName);
    },
    sessionStorageSave:function(itemName,itemValue){
        if(common.isDebug){
            console.log(itemName);
            console.log(itemValue);
        }
        window.sessionStorage.setItem(itemName, itemValue);
    },
    /**
     * 通用初始化界面方法，当所有页面都要调某一方法时集中在这里调用。
     */
    initUI:function(){
        if(common.isDebug){
            console.log("通用初始化。");
        }
    }
});


common.initUI();
//-------------------------------以下是单元测试部分-------------------------------------------------
var commonTest=new Object({
    getBasePathTest:function(){
        console.log("前台地址|"+common.getBasePath().frontPath+"|");
        console.log("后台地址|"+common.getBasePath().backPath+"|");
    },
    objectToJsonTest:function(){
        var person={"name":"vsked","age":18,"isMan":true};
        console.log(common.objectToJson(person));
    },
    jsonToObjectTest:function(){
        var personStr='{"name":"vsked","age":18,"isMan":true}';
        console.log(common.jsonToObject(personStr));
    },
    trimTest:function(){
        console.log("|"+common.trim("    前面有空格")+"|");
        console.log("|"+common.trim("后面有空格     ")+"|");
        console.log("|"+common.trim("中   间   有   空     格")+"|");
        console.log("|"+common.trim("     前     后   中 都     有   空   格     ")+"|");
    },
    localStorageRemoveTest:function(){
        common.localStorageRemove("commonTestName111");
    },
    localStorageGetTest:function(){
        console.log(common.localStorageGet("commonTestName111"));
    },
    localStorageSaveTest:function(){
        common.localStorageSave("commonTestName111","commonTestValue222");
    },
    sessionStorageRemoveTest:function(){
        common.sessionStorageRemove("sessionaacommonTestName111");
    },
    sessionStorageGetTest:function(){
        console.log(common.sessionStorageGet("sessionaacommonTestName111"));
    },
    sessionStorageSaveTest:function(){
        common.sessionStorageSave("sessionaacommonTestName111","commonsessionTestValue222");
    },
    initUITest:function(){
        common.initUI();
    },
    initTest:function(){
        if(common.isTest==true){
            console.log("common.js 测试开始");
            commonTest.getBasePathTest();
            commonTest.objectToJsonTest();
            commonTest.jsonToObjectTest();
            commonTest.trimTest();
            commonTest.localStorageSaveTest();
            commonTest.localStorageGetTest();
            commonTest.localStorageRemoveTest(); //注释本句，解开本句注释测试移除
            commonTest.sessionStorageSaveTest();
            commonTest.sessionStorageGetTest();
            commonTest.sessionStorageRemoveTest(); //注释本句，解开本句注释测试移除
            commonTest.initUITest();
            console.log("common.js 测试结束");
        }
    }
});

commonTest.initTest();