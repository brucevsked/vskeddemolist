package com.jat.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LongTest {

    private static final Logger log = LoggerFactory.getLogger(LongTest.class);

    @Test
    public void compare(){
        Long a=new Long(99L);
        Long b=new Long(99L);
        boolean r=(a.longValue()==b.longValue());
        log.info("推荐用这个，比较结果:{}",r);

        boolean r1=a.equals(b);
        log.info("比较结果:{}",r1);
    }
}
