package com.vsked.auth.infrastructure.persistence.jpa;

import com.vsked.BaseApplicationTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;


public class AccountRepositoryTest extends BaseApplicationTest {

    private static final Logger log = LoggerFactory.getLogger(AccountRepositoryTest.class);

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByName(){
        String name="vsked";
        AccountDTO account=accountRepository.findByName(name);
        log.debug(account.toString());
    }

}
