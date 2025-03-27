package com.jat.exam.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IdTest {

    private static final Logger log = LoggerFactory.getLogger(IdTest.class);

    @Test
    public void create(){
        Id id=new Id(1,"用户");
        log.debug("{}",id);
        Assert.assertEquals(id.getId(),1);
    }

    @Test
    public void createError1(){
        Assert.expectThrows(IllegalArgumentException.class,()->new Id(null,"角色"));
    }
}
