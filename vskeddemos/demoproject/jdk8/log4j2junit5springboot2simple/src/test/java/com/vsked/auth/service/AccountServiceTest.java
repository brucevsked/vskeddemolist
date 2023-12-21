package com.vsked.auth.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.vsked.test.BaseTestWithoutTransactional;

public class AccountServiceTest extends BaseTestWithoutTransactional {
	
	private static final Logger log = LoggerFactory.getLogger(AccountServiceTest.class);
	
	@Autowired
	AccountService accountService;
	
    @Test
    public void accountIdTest() throws Exception {
		if(log.isTraceEnabled()){
			log.trace("start");
		}

		String accountId=accountService.getAccountId();
    	log.info("accountId is :{}" ,accountId );

		if(log.isTraceEnabled()){
			log.trace("end");
		}
    }

}
