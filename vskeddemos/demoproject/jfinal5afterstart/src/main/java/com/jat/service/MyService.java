package com.jat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 注入第一步，先生成一个要调用的类
 */
public class MyService {

    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    public void createUser(){
        log.info("you has create the user");
    }
}
