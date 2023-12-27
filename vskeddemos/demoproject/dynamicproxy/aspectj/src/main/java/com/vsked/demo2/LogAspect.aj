package com.vsked.demo2;

public aspect LogAspect {

    pointcut logPointCut():execution(* com.vsked.demo2.Log..*(..));

    before(): logPointCut(){
        System.out.println("日志前|||||||||||||");
    }

    after(): logPointCut(){
        System.out.println("日志后-----------");
    }
}
