package com.jat.model.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenTest {
    private static final Logger log = LoggerFactory.getLogger(TokenTest.class);

    @Test
    public void create(){
        Integer id1=1;
        String name1="token1";
        Token token1=new Token(id1,name1);
        log.debug("{}",token1);
        Assert.assertEquals(token1.getId(),1);
        Assert.assertEquals(token1.getName(),"token1");
        Assert.assertFalse(token1.getExpire());
    }
}
