package com.jat.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.jat.auth.infrastructure.persistence.jpa.AccountDTO;
import com.jat.auth.web.model.LoginInfoVO;
import com.jat.test.BaseTestWithTransactional;

public class TestServiceTest extends BaseTestWithTransactional {

	private static final Logger log = LoggerFactory.getLogger(TestServiceTest.class);
	
	@Autowired
	TestService testService;

	@Test
	public void add() throws Exception {
		log.trace("TestServiceTest add start");
		LoginInfoVO loginInfo = new LoginInfoVO();
		loginInfo.setPassword("passAdd1");
		loginInfo.setUsername("userNameAdd1");
		testService.add(loginInfo);
		log.trace("TestServiceTest add end ");
	}
	
	@Test
	public void update() throws Exception {
		log.trace("TestServiceTest update start");
		LoginInfoVO loginInfo = new LoginInfoVO();
		loginInfo.setId(2);
		loginInfo.setPassword("updatepass2");
		loginInfo.setUsername("updatename2");
		testService.update(loginInfo);
		log.trace("TestServiceTest update end ");
	}
	
	@Test
	public void delete() throws Exception {
		log.trace("TestServiceTest delete start");
		Long accountId = new Long(2);
		testService.delete(accountId);
		log.trace("TestServiceTest delete end ");
	}
	
	@Test
	public void search() throws Exception {
		log.trace("TestServiceTest search start");
		Long accountId = new Long(2);
		AccountDTO account = testService.search(accountId);
		log.debug(account.toString());
		log.trace("TestServiceTest search end ");
	}

}
