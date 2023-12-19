package com.vsked;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserTest {

    private static final Logger log = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void createUser(){
        log.debug("===================测试创建用户完成");
    }

    @Test
    @Order(1)
    public void seq1(){
        log.debug("now run test:1");
    }

    @Test
    @Order(2)
    public void seq2(){
        log.debug("now run test:2");
    }
}
