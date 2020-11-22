"use strict"

$(function(){

    console.log('init ok');
    //logicGateTest.testAll();
    adderTest.testAll();
    
});

/**
 * 道生一，一生二，二生三，三生万物
 * 万物从not开始，然后注入两个数字0，1，使用了与或非三种方法生成了整个宇宙
 * 也许我们生活在一个计算机世界哟，阴为0，阳为1
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


var adder=new Object({
    /**
     * 半加器有两个输入和两个输出，输入可以标识为A、B，输出通常标识为求和（Sum）和进位（Carry）。
     * 输入经异或（XOR）运算后即为S，经和（AND）运算后即为C。
     * 半加器有两个二进制的输入，其将输入的值相加，并输出结果到和（Sum）和进位（Carry）。
     * 半加器虽能产生进位值，但半加器本身并不能处理进位值。
     * @param {*} a 加数
     * @param {*} b 被加数
     * 返回数据格式{s:运算后结果,c:进位}
     */
    halfAdder:function(a,b){
        return {s:logicGate.xor(a,b),c:logicGate.and(a,b)};
    },
    /**
     * 加法器是产生数的和的装置。加数和被加数为输入，和数与进位为输出的装置为半加器。
     * 若加数、被加数与低位的进位数为输入，而和数与进位为输出则为全加器。
     * 常用作计算机算术逻辑部件，执行逻辑操作、移位与指令调用。在电子学中，加法器是一种数位电路，其可进行数字的加法计算。
     * 三码，主要的加法器是以二进制作运算。
     * 由于负数可用二的补数来表示，所以加减器也就不那么必要。
     * 
     * 
     * @param {*} a 加数
     * @param {*} b 被加数
     * @param {*} c 低位进位
     */
    fullAdder:function(a,b,c){
        var s1=logicGate.xor(a,b);
        var sum=logicGate.xor(s1,c);
        var t3=logicGate.and(a,b);
        var t1=logicGate.and(a,c);
        var t2=logicGate.and(b,c);
        var count=logicGate.or(logicGate.or(t1,t2),t3);
        return {s:sum,c:count};
    }
});


var adderTest=new Object({
    halfAdder:function(){
        console.log("0 halfAdder 0 :");
        console.log(adder.halfAdder(0,0));
        console.log("0 halfAdder 1 :");
        console.log(adder.halfAdder(0,1));
        console.log("1 halfAdder 0 :");
        console.log(adder.halfAdder(1,0));
        console.log("1 halfAdder 1 :"); 
        console.log(adder.halfAdder(1,1));
    },
    fullAdder:function(){
        console.log("0 fullAdder 0 carry 0 :");
        console.log(adder.fullAdder(0,0,0));
        console.log("0 fullAdder 1 carry 0 :");
        console.log(adder.fullAdder(0,1,0));
        console.log("1 fullAdder 0 carry 0 :");
        console.log(adder.fullAdder(1,0,0));
        console.log("1 fullAdder 1 carry 0 :");
        console.log(adder.fullAdder(1,1,0));
        console.log("0 fullAdder 0 carry 1 :");
        console.log(adder.fullAdder(0,0,1));
        console.log("0 fullAdder 1 carry 1 :");
        console.log(adder.fullAdder(0,1,1));
        console.log("1 fullAdder 0 carry 1 :");
        console.log(adder.fullAdder(1,0,1));
        console.log("1 fullAdder 1 carry 1 :");
        console.log(adder.fullAdder(1,1,1));
    },
    testAll:function(){
        //adderTest.halfAdder();//test ok
        adderTest.fullAdder();
    }
});


var vskedcpu=new Object({

});

