package com.vsked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class UserTest {

    private static final Logger log = LoggerFactory.getLogger(UserTest.class);

    @Test(dependsOnMethods = {"com.jat.RoleTest.createRole"})
    public void createUser(){
        log.debug("===================测试创建用户完成");
    }
}
