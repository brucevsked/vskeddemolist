'use strict'

$(function(){

});

var common=new Object({
    evnType:1,//1 演示,2生产,3集团
    tokenName:'token',
    getBaseInfo:function(){
        if(common.evnType==1){
            return {
                baseFrontPath:'http://127.0.0.1:8080/myui/',
                baseBackPath:'http://127.0.0.1:8181/'
            };
        }else{
            return {
                baseFrontPath:'http://127.0.0.1:8080/myui/',
                baseBackPath:'http://127.0.0.1:8181/'
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