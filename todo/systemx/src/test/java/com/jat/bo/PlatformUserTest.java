package com.jat.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlatformUserTest {

    private static final Logger log = LoggerFactory.getLogger(PlatformUserTest.class);

    @Test
    public void create(){
        PlatformUser user=new PlatformUser(1L,"admin",null);
        log.debug("{}",user);
        Assert.assertEquals(user.getId().getId(),1L);
        Assert.assertEquals(user.getName().getName(),"admin");
    }

}
