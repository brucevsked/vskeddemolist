package com.vsked.auth.infrastructure.repository.jpa;

import com.vsked.auth.domain.PO.AccountPO;
import com.vsked.test.ProjectSpringBaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class JpaAccountRepositoryTest extends ProjectSpringBaseTest {

    private static final Logger log = LoggerFactory.getLogger(JpaAccountRepositoryTest.class);

    @Autowired
    JpaAccountRepository jpaAccountRepository;


    @Test
    public void findById(){
        log.debug("start log");
        Long accountId=new Long(1);
        AccountPO accountPO=jpaAccountRepository.findById(accountId).get();
        log.debug(accountPO.toString());

    }


}
