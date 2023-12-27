package com.jat.demo3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LazyBeanPropertiesCglibTest {

    private static final Logger log = LoggerFactory.getLogger(LazyBeanPropertiesCglibTest.class);

    @Test
    public void createUser(){
        LazeBeanProperties lazeBeanProperties=new LazeBeanProperties("a",15);
        OnlyOne onlyOne1=lazeBeanProperties.getOnlyOne();
        log.info(onlyOne1.getKey()+onlyOne1.getValue());
        OnlyOne onlyOne2=lazeBeanProperties.getOnlyOne();
        log.info(onlyOne2.getKey()+onlyOne2.getValue());

        EveryTime everyTime1=lazeBeanProperties.getEveryTime();
        log.info(everyTime1.getSleepName()+everyTime1.getArea()+everyTime1.getWidth());//3次因为调用了三次子类方法
        EveryTime everyTime2=lazeBeanProperties.getEveryTime();
        log.info(everyTime2.getSleepName()+everyTime2.getArea());//2次因为调了两次子类方法
        EveryTime everyTime3=lazeBeanProperties.getEveryTime();
        log.info(everyTime3.getSleepName());//1次，你懂得


    }
}
