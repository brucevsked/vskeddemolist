'use strict'

$(function(){
    login.initUI();
});

var login=new Object({
    username:'admin',
    password:'123',
    validate:function(){
        login.username=$('#username').val();
        login.password=$('#password').val();
        if(common.isBlank(login.username)){
            return '用户名不能为空!';
        }
        if(common.isBlank(login.password)){
            return '密码不能为空!';
        }
        return true;
    },
    login:function(){
        var validateResult=login.validate();
        if(validateResult==true){
            console.log('success login'+common.getBaseInfo().baseBackPath);
            var loginPath='';
            loginPath+=common.getBaseInfo().baseBackPath+'authentication/form';
            $.post(loginPath,{ username: login.username,password: login.password },function (dt){
                if(dt.code!='0'){
                    console.log(dt);
                    console.log('login fail please check');
                }else{
                    console.log(dt);
                    console.log(commo.getBaseInfo().baseFrontPath);
                    console.log('login success')
                    //$(location).prop('href', common.getBaseInfo().baseFrontPath+'index.html');
                }
            },"json");
        }else{
            console.log(validateResult);
        }
    },
    initUI:function(){
        $('#loginBt').on('click',login.login);
    }

});