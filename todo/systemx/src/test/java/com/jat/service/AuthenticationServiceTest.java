package com.jat.service;

import com.jat.bo.PlatformCertificate;
import com.jat.bo.PlatformUserAccount;
import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class AuthenticationServiceTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceTest.class);

    @Resource
    AuthenticationService authenticationService;

    @Test
    public void login(){
        String accountName="sysadmin";
        String password="123456";
        PlatformCertificate platformCertificate=authenticationService.login(accountName,password);
        log.debug("{}",platformCertificate);
    }
}
