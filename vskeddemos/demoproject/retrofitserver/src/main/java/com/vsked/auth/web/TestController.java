package com.vsked.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vsked.auth.service.AccountService;
import com.vsked.auth.web.model.LoginInfoVO;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/test/proc")
    @ResponseBody
    public String testProc(@RequestParam Map<String,Object> paraMap){
        if(log.isDebugEnabled()){
            log.debug("{}",paraMap);
        }
        return "test all right";
    }

    @PostMapping("/test/procJson")
    @ResponseBody
    public String testProcJson(@RequestBody String jsonContent){
        if(log.isDebugEnabled()){
            log.debug("{}",jsonContent);
        }
        return "test all right json";
    }

    @PostMapping("/test/procHeader1")
    @ResponseBody
    public String testProcHeader1(HttpServletRequest request){
        if(log.isDebugEnabled()){
            StringBuilder sb = new StringBuilder();
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                log.debug("||||||||||||||||||||||||||||||||"+headerName);
                String headerValue=request.getHeader(headerName);
                sb.append(headerValue);
            }
            log.debug("{}",sb.toString());
        }
        return "test all right header";
    }

}
