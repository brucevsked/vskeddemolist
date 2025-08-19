package com.vsked.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.testng.annotations.Test;

public class PasswordEncoderTest {

    private static final Logger log = LoggerFactory.getLogger(PasswordEncoderTest.class);

    @Test
    public void BCryptPasswordEncoderTest(){
        BCryptPasswordEncoder bcp=new BCryptPasswordEncoder();
        String pass=bcp.encode("123456");
        log.info("加密后的密码：{}" , pass);
    }

}
