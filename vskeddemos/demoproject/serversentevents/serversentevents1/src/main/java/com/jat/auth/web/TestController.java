package com.jat.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jat.auth.service.AccountService;
import com.jat.auth.web.model.LoginInfoVO;

@RestController
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
    AccountService accountService;
	
	@PostMapping("/test")
    @ResponseBody
    public String test1(@ModelAttribute LoginInfoVO loginInfo){
        if(log.isTraceEnabled()){
            log.trace("start");
        }

        String accountId=accountService.getAccountId();

        if(log.isTraceEnabled()){
            log.trace("end");
        }

        return accountId;
    }	

}
