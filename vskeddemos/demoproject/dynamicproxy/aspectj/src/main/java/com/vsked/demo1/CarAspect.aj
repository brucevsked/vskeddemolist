package com.vsked.demo1;

public aspect CarAspect {

    pointcut carPointCut():execution(* com.vsked.demo1.Car.run());

    before(): carPointCut(){
        System.out.println("车子启动前|||||||||||||");
    }

    after(): carPointCut(){
        System.out.println("车子跑完后-----------");
    }

}
