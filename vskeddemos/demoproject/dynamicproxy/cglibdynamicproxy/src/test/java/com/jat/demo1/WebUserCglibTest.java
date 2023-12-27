package com.jat.demo1;

import net.sf.cglib.proxy.Enhancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class WebUserCglibTest {

    private static final Logger log = LoggerFactory.getLogger(WebUserCglibTest.class);

    @Test
    public void createUser(){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(WebUser.class);
        enhancer.setCallback(new MyInterceptor());
        WebUser targetObject2=(WebUser)enhancer.create();

        log.info("当前类是:{}",targetObject2);
        log.info("第1个方法是:{}",targetObject2.checkUserName("mynameisgood"));
        log.info("第2个方法是:{}",targetObject2.checkUserBirth("2021-06-06"));
        targetObject2.checkUserPassword("123456");
    }
}
