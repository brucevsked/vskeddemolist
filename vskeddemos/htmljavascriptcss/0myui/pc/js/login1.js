"use strict"

class Login{

    toLogin(){
        window.location.href="index1.html";
    }

    init(){
        document.getElementById("accountName").focus();
        var loginBt=document.getElementById("loginBt");
        loginBt.addEventListener("click",this.toLogin,false);
    }

}

var login=new Login();
login.init();