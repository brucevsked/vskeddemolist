package com.jat.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class PlatformUserAccountTest {

    private static final Logger log = LoggerFactory.getLogger(PlatformUserAccountTest.class);

    @Test
    public void create(){
        PlatformAccount account=new PlatformAccount(1L,"admin","adminPassword");
        PlatformUser user=new PlatformUser(1L,"admin",null);

        PlatformUserAccount userAccount=new PlatformUserAccount(user,account);
        log.debug("{}",userAccount);


    }
}
