package com.vsked.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  
public class TestWebController {
    
	private static final Logger log = LoggerFactory.getLogger(TestWebController.class);
	
    @GetMapping("/")
    public String test(){
    	log.info("TestWebController test start");
        return "TestFile.html"; 
    }

}
