package com.jat.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.jat.test.BaseTestWithoutTransactional;

public class AccountServiceTest extends BaseTestWithoutTransactional {
	
	private static final Logger log = LoggerFactory.getLogger(AccountServiceTest.class);
	
	@Autowired
	AccountService accountService;
	
    @Test
    public void test1() throws Exception {
		if(log.isTraceEnabled()){
			log.trace("start");
		}

		String accountId=accountService.getAccountId();
    	log.info("accountId is :{}" ,accountId );

		if(log.isTraceEnabled()){
			log.trace("end");
		}
    }
    
    @Test
    public void test2() {
    	accountService.getAccountList();

    }

	@Test
	public void test3() {
		accountService.getAccountList1("myTest");

	}

}
