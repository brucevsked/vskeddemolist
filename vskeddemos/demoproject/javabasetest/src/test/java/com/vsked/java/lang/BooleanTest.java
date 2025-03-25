package com.vsked.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class BooleanTest {

    private static final Logger log = LoggerFactory.getLogger(BooleanTest.class);

    @Test
    public void create(){
        Boolean b1=new Boolean(true);
        log.info("当前真:{}",b1);
        Boolean b2=new Boolean(false);
        log.info("当前假:{}",b2);
    }

    @Test
    public void use1(){
        Boolean b1=new Boolean(true);
        if(b1){
            log.info("真的在这里");
        }

        Boolean b2=new Boolean(false);
        if(!b2){
            log.info("全是假的。。哇。。。呜呜呜呜呜呜");
        }


    }
}
