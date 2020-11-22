"use strict"

$(function(){

    console.log('init ok');
    logicGateTest.testAll();
    
});

/**
 * 道生一，一生二，二生三，三生万物
 * 万物从not开始，然后注入两个数字0，1，使用了与或非三种方法生成了整个宇宙
 * 也许我们生活在一个计算机世界哟
 */
var logicGate=new Object({
    /**
     * A'
     * @param {*} a 
     */
    not:function(a){//非
        return (!a)?1:0;
    },
    /**
     * A*B
     * @param {*} a 
     * @param {*} b 
     */
    and:function(a,b){//与
        return a&&b;
    },
    /**
     * A + B
     * @param {*} a 
     * @param {*} b 
     */
    or:function(a,b){//或
        return a||b;
    },
    /**
     * (A*B)'
     * @param {*} a 
     * @param {*} b 
     */
    nand:function(a,b){
        return logicGate.not(logicGate.and(a,b));
    },
    /**
     * (A + B)'
     * @param {*} a 
     * @param {*} b 
     */
    nor:function(a,b){
        return logicGate.not(logicGate.or(a,b));
    },
    /**
     * A'*B + A*B'
     * @param {*} a 
     * @param {*} b 
     */
    xor:function(a,b){
        return logicGate.or(logicGate.and(logicGate.not(a),b),logicGate.and(a,logicGate.not(b)));
    },
    /**
     * A*B + A'*B'
     * @param {*} a 
     * @param {*} b 
     */
    xnor:function(a,b){
        return logicGate.or(logicGate.and(a,b),logicGate.and(logicGate.not(a),logicGate.not(b)));
    }

});

var logicGateTest=new Object({
    not:function(){
       var a=0;
       console.log("0 not :"+logicGate.not(a));
       var b=1;
       console.log("1 not :"+logicGate.not(b));
    },
    and:function(){
        console.log("0 and 0 :"+logicGate.and(0,0));
        console.log("0 and 1 :"+logicGate.and(0,1));
        console.log("1 and 0 :"+logicGate.and(1,0));
        console.log("1 and 1 :"+logicGate.and(1,1));
    },
    or:function(){
        console.log("0 or 0 :"+logicGate.or(0,0));
        console.log("0 or 1 :"+logicGate.or(0,1));
        console.log("1 or 0 :"+logicGate.or(1,0));
        console.log("1 or 1 :"+logicGate.or(1,1));
    },
    nand:function(){
        console.log("0 nand 0 :"+logicGate.nand(0,0));
        console.log("0 nand 1 :"+logicGate.nand(0,1));
        console.log("1 nand 0 :"+logicGate.nand(1,0));
        console.log("1 nand 1 :"+logicGate.nand(1,1));
    },
    nor:function(){
        console.log("0 nor 0 :"+logicGate.nor(0,0));
        console.log("0 nor 1 :"+logicGate.nor(0,1));
        console.log("1 nor 0 :"+logicGate.nor(1,0));
        console.log("1 nor 1 :"+logicGate.nor(1,1));
    },
    xor:function(){
        console.log("0 xor 0 :"+logicGate.xor(0,0));
        console.log("0 xor 1 :"+logicGate.xor(0,1));
        console.log("1 xor 0 :"+logicGate.xor(1,0));
        console.log("1 xor 1 :"+logicGate.xor(1,1));
    },
    xnor:function(){
        console.log("0 xnor 0 :"+logicGate.xnor(0,0));
        console.log("0 xnor 1 :"+logicGate.xnor(0,1));
        console.log("1 xnor 0 :"+logicGate.xnor(1,0));
        console.log("1 xnor 1 :"+logicGate.xnor(1,1));
    },
    testAll:function(){
        logicGateTest.not(); //test ok
        logicGateTest.and(); //test ok
        logicGateTest.nand();  //test ok
        logicGateTest.or();  //test ok     
        logicGateTest.nor();  //test ok   
        logicGateTest.xor();  //test ok   
        logicGateTest.xnor();  //test ok   
    }

});


var vskedcpu=new Object({

});

