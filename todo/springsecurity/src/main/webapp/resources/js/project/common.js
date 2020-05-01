'use strict'

$(function(){

});

var common=new Object({
    evnType:1,//1 演示,2生产,3集团
    tokenName:'token',
    getBaseInfo:function(){
        if(common.evnType==1){
            return {
                baseFrontPath:'http://localhost:8080/myui/',
                baseBackPath:'https://127.0.0.1:8080/yourback/'
            };
        }else{
            return {
                baseFrontPath:'http://localhost:8181/lovecode/',
                baseBackPath:'https://127.0.0.1:8181/authhere/'
            };
        }
    },
    isBlank:function(o){
        if(o!=null &&
            o!=undefined &&
            common.trim(o).length>0){
            return false;
        }else{
            return true;
        }
    },
    trim:function(o){
        return o.replace(/\s+/g,"");
    },
    store:function(o){
        localStorage.setItem(common.tokenName,o);
    }

});