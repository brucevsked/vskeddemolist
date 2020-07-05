package com.vsked.auth.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    public String test1(){
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        String result="testok1";
        log.debug("|"+result+"|");
        return result;

    }
}
