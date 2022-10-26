package com.jat.service;

import com.jat.bo.PlatformUserAccount;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class PlatformUserAccountServiceTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(PlatformUserAccountServiceTest.class);

    @Resource
    PlatformUserAccountService platformUserAccountService;

    @Test
    public void register(){
        String accountName="testRegister";
        String password="myPass123";
        PlatformUserAccount userAccount=platformUserAccountService.register(accountName,password);
        log.debug("{}",userAccount);
    }
}
