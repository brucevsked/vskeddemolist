package com.jat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyService {

    private static final Logger log = LoggerFactory.getLogger(MyService.class);

    public void createUser(){
        log.info("you has create the user");
    }
}
