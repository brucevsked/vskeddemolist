package com.vsked.java.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Optional;

public class OptionalTest {

    private static final Logger log = LoggerFactory.getLogger(OptionalTest.class);

    @Test
    public void isPresentTest(){
        Integer v1 = null;
        Integer v2 = new Integer(10);

        //Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(v1);
        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(v2);

        log.info("这个窗口是空的么:{}",a.isPresent());//为null返回false
        log.info("这个窗口是空的么:{}",b.isPresent());//不为空返回true
    }

    @Test
    public void getTest(){
        Integer v1 = null;
        Integer v2 = new Integer(20);

        //Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(v1);
        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(v2);

        Integer ar=a.orElse(null);//如果存在该值，返回值， 否则返回 other(null)。
        Integer br=b.get();

        log.info("ar值是:{}",ar);
        log.info("br值是:{}",br);
    }

    @Test
    public void exceptionTest(){
        try {
            Integer v1 = null;
            //Optional.ofNullable - 允许传递为 null 参数
            Optional<Integer> a = Optional.ofNullable(v1);
            Integer ar = a.orElseThrow(() -> new NullPointerException("空指值或自定义异常"));

            log.info("ar值是:{}", ar);
        }catch (Exception e){
            log.error("没有这个值呀!"+e.getMessage(),e);
        }
    }

}
