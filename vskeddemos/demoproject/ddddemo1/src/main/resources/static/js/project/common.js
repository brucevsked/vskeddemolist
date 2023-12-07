"use strict"

var common=new Object({
    localStoreName:"borrowBookAccountInfo",
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
    /**
     * 任何向后台请求都要调用此方法
     * 获取后台API全地址
     * 传入示例account/name
     * 返回http://127.0.0.1:8181/account/name
     * @param apiPath
     */
    getAPIPath:function(apiPath){
        return common.getBasePath().backPath+apiPath;
    },
    /**
     * 去空格
     * @param str
     * @returns {*}
     */
    trim:function(str){
        return str.replace(/\s/g,"");
    },
    /**
     * 跳转页面
     * @param pageUrl
     */
    jumpPage:function(pageUrl){
        $(location).prop('href', common.getBasePath().frontPath+pageUrl);
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
        if(serverResponseData==null || serverResponseData==undefined){
            alert("接收响应数据失败，请联系管理员");
            return false;
        }

        if(serverResponseData.code==null || serverResponseData.code==undefined ||serverResponseData.msg==null || serverResponseData.msg==undefined){
            alert("响应数据结构异常，请联系管理员");
            return false;
        }

    },
    /**
     * 保存账户登录信息
     * 数据结构为
     * {
     *    "accountName":"显示名称",
     *    "accountToken":"xxx.yyy.zzz"
     * }
     * @param accountInfo
     */
    saveAccountInfo:function(accountInfo){
        common.localStorageSave(common.localStoreName,accountInfo);
    },
    localStorageRemove:function(itemName){
        window.localStorage.removeItem(itemName);
    },
    localStorageGet:function(itemName){
        return window.localStorage.getItem(itemName);
    },
    localStorageSave:function(itemName,itemValue){
        window.localStorage.setItem(itemName, itemValue);
    },
    /**
     * 通用初始化界面方法，当所有页面都要调某一方法时集中在这里调用。
     */
    initUI:function(){
        console.log("通用初始化。");
    }
});


common.initUI();
//-------------------------------以下是单元测试部分-------------------------------------------------
var commonTest=new Object({
    getBasePathTest:function(){
        console.log("前台地址|"+common.getBasePath().frontPath+"|");
        console.log("后台地址|"+common.getBasePath().backPath+"|");
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
    initUITest:function(){
        common.initUI();
    },
    initTest:function(){
        if(common.isTest==true){
            console.log("common.js 测试开始");
            commonTest.getBasePathTest();
            commonTest.trimTest();
            commonTest.localStorageSaveTest();
            commonTest.localStorageGetTest();
            commonTest.localStorageRemoveTest(); //注释本句，解开本句注释测试移除
            commonTest.initUITest();
            console.log("common.js 测试结束");
        }
    }
});

commonTest.initTest();