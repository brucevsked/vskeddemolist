package com.jat.system.service;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class AuthenticationServiceTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceTest.class);
    @Autowired
    AuthenticationService authenticationService;

    @Test
    public void authentication(){
        String userName="admin";
        String password="admin";
        String token=authenticationService.authentication(userName,password);
        log.info("{}",token);
    }
}
