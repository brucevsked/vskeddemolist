package com.vsked.auth.infrastructure.repository.jpa.specification;

import com.vsked.auth.domain.PO.AccountPO;
import com.vsked.auth.infrastructure.repository.jpa.JpaAccountRepository;
import com.vsked.test.ProjectSpringBaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.testng.annotations.Test;

public class JpaAccountSpecByNameTest extends ProjectSpringBaseTest {

    private static final Logger log = LoggerFactory.getLogger(JpaAccountSpecByNameTest.class);

    @Autowired
    JpaAccountRepository jpaAccountRepository;


    @Test
    public void getAccountByName(){
        log.debug("start log");
        String accountName="vsked";
        Specification<AccountPO> accountPOSpec=new JpaAccountSpecByName(accountName);
        AccountPO accountPO=jpaAccountRepository.findOne(accountPOSpec).get();
        log.debug(accountPO.toString());

    }


}
