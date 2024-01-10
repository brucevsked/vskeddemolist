package com.jat.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	private static final Logger log = LoggerFactory.getLogger(TestService.class);
	
    public String test1(){
    	log.info("TestService start");
        String result="testok1";
        log.debug("|"+result+"|");
        log.info("TestService end");
        return result;
    }
    
}
