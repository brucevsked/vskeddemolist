package com.jat.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlatformAccountTest {

    private static final Logger log = LoggerFactory.getLogger(PlatformAccountTest.class);

    @Test
    public void create(){
        PlatformAccount account=new PlatformAccount(1L,"admin","adminPassword");
        log.debug("{}",account);

        Assert.assertEquals(account.getId().getId(),1L);
        Assert.assertEquals(account.getName().getName(),"admin");
        Assert.assertEquals(account.getPassword().getPassword(),"adminPassword");

    }
}
