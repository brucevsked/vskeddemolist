package com.jat.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jat.auth.service.TestService;
import com.jat.auth.web.model.LoginInfoVO;

@RestController
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
    TestService testService;
	
	@PostMapping("/test")
    @ResponseBody
    public String test1(@ModelAttribute LoginInfoVO loginInfo){
        log.debug("|"+loginInfo.toString()+"|");
        return testService.test1();
    }	

}
