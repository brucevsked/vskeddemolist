package com.jat.infrastructure.persistence.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import com.jat.auth.infrastructure.persistence.jpa.AccountDTO;
import com.jat.auth.infrastructure.persistence.jpa.AccountRepository;
import com.jat.test.BaseTestWithTransactional;

public class AccountRepositoryTest extends BaseTestWithTransactional {
	
    private static final Logger log = LoggerFactory.getLogger(AccountRepositoryTest.class);

    @Autowired
    AccountRepository accountRepository;
    
    @Test
    public void findByid(){
    	log.trace("AccountRepositoryTest findByid start");
        AccountDTO account=accountRepository.findByid(1);
        log.debug(account.toString());
        log.trace("AccountRepositoryTest findByid end");
    }
    
    @Test
    public void save() {
    	log.trace("AccountRepositoryTest save start");
    	AccountDTO accountDTO = new AccountDTO();
    	Long accountId = new Long(2);
    	accountDTO.setId(accountId);
    	accountDTO.setName("user2");
    	accountDTO.setPass("pass2");
    	AccountDTO account = accountRepository.save(accountDTO);
    	log.debug(account.toString());
    	log.trace("AccountRepositoryTest save end");
    }
    
    @Test
    public void update() {
    	log.trace("AccountRepositoryTest update start");
    	AccountDTO accountDTO = new AccountDTO();
    	Long accountId = new Long(1);
    	accountDTO.setId(accountId);
    	accountDTO.setName("updateuser1");
    	accountDTO.setPass("updatepass1");
    	AccountDTO account = accountRepository.save(accountDTO);
    	log.debug(account.toString());
    	log.trace("AccountRepositoryTest update end");
    }
    
    @Test
    public void delete() {
    	log.trace("AccountRepositoryTest delete start");
    	int deleteCount = accountRepository.deleteUserById(2);
    	log.debug(" "+ deleteCount);
    	log.trace("AccountRepositoryTest delete end");
    }
    
}
