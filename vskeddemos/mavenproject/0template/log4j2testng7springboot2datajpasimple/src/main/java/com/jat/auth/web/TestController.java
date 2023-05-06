package com.jat.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jat.auth.infrastructure.persistence.jpa.AccountDTO;
import com.jat.auth.service.TestService;
import com.jat.auth.web.model.LoginInfoVO;

@RestController
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
    TestService testService;
	
	@PostMapping("/addAccount")
    @ResponseBody
    public String addAccount(@ModelAttribute LoginInfoVO loginInfo){
		log.info("TestController addAccount start");
        log.debug("|"+loginInfo.toString()+"|");
        testService.add(loginInfo);
        log.info("TestController addAccount end");
        return "testok1";
    }
	
	@PostMapping("/updateAccount")
    @ResponseBody
    public void updateAccount(@ModelAttribute LoginInfoVO loginInfo){
		log.info("TestController updateAccount start");
        log.debug("|"+loginInfo.toString()+"|");
        testService.update(loginInfo);
        log.info("TestController updateAccount end");
    }
	
	@PostMapping("/deleteAccount")
    @ResponseBody
    public int deleteAccount(@ModelAttribute LoginInfoVO loginInfo){
		log.info("TestController deleteAccount start");
        log.debug("|"+loginInfo.toString()+"|");
        int effectRow = testService.delete(loginInfo.getId());
        log.info("TestController deleteAccount end");
        return effectRow ;
    }
	
	@PostMapping("/searchAccount")
    @ResponseBody
    public AccountDTO searchAccount(@ModelAttribute LoginInfoVO loginInfo){
		log.info("TestController searchAccount start");
        log.debug("|"+loginInfo.toString()+"|");
        AccountDTO account= testService.search(loginInfo.getId());
        log.debug("|"+account.toString()+"|");
        log.info("TestController searchAccount end");
        return account ;
    }
	
}
