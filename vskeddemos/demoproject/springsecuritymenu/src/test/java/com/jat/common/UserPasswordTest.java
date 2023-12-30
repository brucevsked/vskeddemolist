package com.jat.common;

import com.jat.test.BaseTestWithoutTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.testng.annotations.Test;

public class UserPasswordTest extends BaseTestWithoutTransactional {

    private static final Logger log = LoggerFactory.getLogger(UserPasswordTest.class);

    @Test
    public void encodePassword(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //加密
        String encode = bCryptPasswordEncoder.encode("myUser");
        log.info("{bcrypt}{}",encode);
        log.info("{}",encode);
    }
}
