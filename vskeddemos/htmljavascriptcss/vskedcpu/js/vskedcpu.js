
"use strict"

//https://nandgame.com/

class VskedCpu{
    power=1;

    c1(a,b){
        if(a==1 && b==0){return 0;} 
        if(a==0 && b==1){return 1;} 
        if(a==1 && b==1){return 0;} 
        return 0;
    }

    c2(a,b){
        if(a==1 && b==0){return 0;} 
        if(a==0 && b==1){return 0;} 
        if(a==1 && b==1){return 1;} 
        return 0;
    }

    c3(a,b){
        //level 1 Nand Logic Gates
        let tmp1=this.c1(0,this.power); //a empty,b connect power
        let tmp2=this.c2(a,b); // a connect,b connect
        let tmp3=this.c1(tmp2,tmp1);
        return tmp3;
    }

    init(){
        console.log(this.power);
        console.log("let's start cpu go.");
    }

}

class VskedCpuTest{
    
    c1Test(){
        let cpu=new VskedCpu();
        console.log('----------start test c1----------');
        console.log('a=1,b=0,',cpu.c1(1,0));
        console.log('a=0,b=1,',cpu.c1(0,1));
        console.log('a=1,b=1,',cpu.c1(1,1));
        console.log('----------end test c1----------');
    }

    c2Test(){
        let cpu=new VskedCpu();
        console.log('----------start test c2----------');
        console.log('a=1,b=0,',cpu.c2(1,0));
        console.log('a=0,b=1,',cpu.c2(0,1));
        console.log('a=1,b=1,',cpu.c2(1,1));
        console.log('----------end test c2----------');
    }

    c3Test(){
        let cpu=new VskedCpu();
        console.log('----------start test c3----------');
        console.log('a=0,b=0,',cpu.c3(0,0));
        console.log('a=0,b=1,',cpu.c3(0,1));
        console.log('a=1,b=0,',cpu.c3(1,0));
        console.log('a=1,b=1,',cpu.c3(1,1));
        console.log('----------end test c3----------');
    }
}

var myCpu=new VskedCpu();
// myCpu.init();

var cpuTest=new VskedCpuTest();
// cpuTest.c1Test();
// cpuTest.c2Test();
cpuTest.c3Test();