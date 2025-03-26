package com.vsked.auth.web;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vsked.auth.service.AccountService;
import com.vsked.auth.web.model.LoginInfoVO;

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

    @GetMapping("/test/{ida}")
    @ResponseBody
    public String test3(@PathVariable("ida") String id,@RequestParam("username") String username,@RequestParam("password") String password){
        if(log.isTraceEnabled()){
            log.trace("start");
        }

        if(log.isInfoEnabled()){
            log.info(id+"testok"+username+password);
        }

        return id+"testok"+username+password;
    }

    @GetMapping("/test2")
    @ResponseBody
    public String test2(){
        return "test2ok";
    }


}
