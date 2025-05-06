package com.vsked.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class SnowflakeTest {

    private static final Logger log = LoggerFactory.getLogger(SnowflakeTest.class);

    @Test
    public void getId(){
        log.info("{}",IdGenerator.getId());
    }

    @Test
    public void getId1(){
        Snowflake snowflake1 = new Snowflake(0, 31);
        log.debug("myId is:{}",snowflake1.nextId());
        Snowflake snowflake2 = new Snowflake(2, 31);
        log.debug("myId is:{}",snowflake2.nextId());
        Snowflake snowflake3 = new Snowflake(3, 31);
        log.debug("myId is:{}",snowflake3.nextId());
        Snowflake snowflake4 = new Snowflake(31, 31);
        log.debug("myId is:{}",snowflake4.nextId());
    }
}
}
