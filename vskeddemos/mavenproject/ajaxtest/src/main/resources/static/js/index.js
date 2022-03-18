"use strict"

var indexPage=new Object({
    basePath:"http://localhost:8181/",
    get1Test:function(){
        console.log("------------------get1test");
        var myUrl=indexPage.basePath+"get1";
        axios.get(myUrl).then(function (dt) {
            console.log(dt);
            document.getElementById("resultDiv").innerHTML=dt.data;
        }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    get2Test:function(){
        console.log("------------------get2test");
        var myUrl=indexPage.basePath+"get2";
        axios.get(myUrl,{
            params:{id:18,name:"big boy get"}})
            .then(function (dt) {
            console.log(dt);
            document.getElementById("resultDiv").innerHTML=dt.data;
        }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    get3Test:async function(){
        console.log("------------------get3test");
        var myUrl=indexPage.basePath+"get3";
        await axios.get(myUrl).then(function (dt) {
            console.log(dt);
        }).catch(function (error) {
            alert(error);
        });
    },
    get4Test:async function(){
        console.log("------------------get4test");
        var myUrl=indexPage.basePath+"get4";
        await axios.get(myUrl).then(function (dt) {
            console.log(dt);
        }).catch(function (error) {
            alert(error);
        });
    },
    get5Test:async function(){
        console.log("------------------get5test");
        var myUrl=indexPage.basePath+"get5";
        await axios.get(myUrl).then(function (dt) {
            console.log(dt);
        }).catch(function (error) {
            alert(error);
        });
    },
    get6Test:async function(){
        await indexPage.get3Test();
        await indexPage.get4Test();
        await indexPage.get5Test();
    },
    post1Test:function(){
        console.log("------------------post1Test");
        var myUrl=indexPage.basePath+"post1";
        axios.post(myUrl).then(function (dt) {
            console.log(dt);
            document.getElementById("resultDiv").innerHTML=dt.data;
        }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    post2Test:function(){
        console.log("------------------post2test");
        var myUrl=indexPage.basePath+"post2";
        var myParams=new FormData();
        myParams.append("id",18);
        myParams.append("name","big boy post");
        axios.post(myUrl,myParams,{headers:{"Content-Type":"application/x-www-form-urlencoded"}})
            .then(function (dt) {
                console.log(dt);
                document.getElementById("resultDiv").innerHTML=dt.data;
            }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    put1Test:function(){
        console.log("------------------put1Test");
        var myUrl=indexPage.basePath+"put1";
        axios.put(myUrl).then(function (dt) {
            console.log(dt);
            document.getElementById("resultDiv").innerHTML=dt.data;
        }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    put2Test:function(){
        console.log("------------------put2test");
        var myUrl=indexPage.basePath+"put2";
        var myParams=new FormData();
        myParams.append("id",18);
        myParams.append("name","big boy put");
        axios.put(myUrl,myParams,{headers:{"Content-Type":"application/x-www-form-urlencoded"}})
            .then(function (dt) {
                console.log(dt);
                document.getElementById("resultDiv").innerHTML=dt.data;
            }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    patch1Test:function(){
        console.log("------------------patch1Test");
        var myUrl=indexPage.basePath+"patch1";
        axios.patch(myUrl).then(function (dt) {
            console.log(dt);
            document.getElementById("resultDiv").innerHTML=dt.data;
        }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    patch2Test:function(){
        console.log("------------------patch2test");
        var myUrl=indexPage.basePath+"patch2";
        var myParams=new FormData();
        myParams.append("id",18);
        myParams.append("name","big boy patch");
        axios.patch(myUrl,myParams,{headers:{"Content-Type":"application/x-www-form-urlencoded"}})
            .then(function (dt) {
                console.log(dt);
                document.getElementById("resultDiv").innerHTML=dt.data;
            }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    delete1Test:function(){
        console.log("-----------------delete1Test");
        var myUrl=indexPage.basePath+"delete1";
        axios.delete(myUrl).then(function (dt) {
            console.log(dt);
            document.getElementById("resultDiv").innerHTML=dt.data;
        }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    delete2Test:function(){
        console.log("------------------delete2test");
        var myUrl=indexPage.basePath+"delete2";
        axios.delete(myUrl,{
            params:{id:18,name:"big boy delete"}})
            .then(function (dt) {
                console.log(dt);
                document.getElementById("resultDiv").innerHTML=dt.data;
            }).catch(function (error) {
            alert(error);
            document.getElementById("resultDiv").innerHTML=error;
        });
    },
    initUI:function(){
        console.log("------------------indexPage");
        var get1Bt=document.getElementById("get1Bt");
        get1Bt.addEventListener("click",indexPage.get1Test,false);
        var get2Bt=document.getElementById("get2Bt");
        get2Bt.addEventListener("click",indexPage.get2Test,false);
        var get3Bt=document.getElementById("get3Bt");
        get3Bt.addEventListener("click",indexPage.get6Test,false);

        var post1Bt=document.getElementById("post1Bt");
        post1Bt.addEventListener("click",indexPage.post1Test,false);
        var post2Bt=document.getElementById("post2Bt");
        post2Bt.addEventListener("click",indexPage.post2Test,false);

        var put1Bt=document.getElementById("put1Bt");
        put1Bt.addEventListener("click",indexPage.put1Test,false);
        var put2Bt=document.getElementById("put2Bt");
        put2Bt.addEventListener("click",indexPage.put2Test,false);

        var patch1Bt=document.getElementById("patch1Bt");
        patch1Bt.addEventListener("click",indexPage.patch1Test,false);
        var patch2Bt=document.getElementById("patch2Bt");
        patch2Bt.addEventListener("click",indexPage.patch2Test,false);

        var delete1Bt=document.getElementById("delete1Bt");
        delete1Bt.addEventListener("click",indexPage.delete1Test,false);
        var delete2Bt=document.getElementById("delete2Bt");
        delete2Bt.addEventListener("click",indexPage.delete2Test,false);


    }
});

indexPage.initUI();