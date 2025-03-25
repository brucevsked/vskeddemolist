package com.vsked.java.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.sql.Date;
import java.sql.Timestamp;

public class TimestampTest {
    private static final Logger log = LoggerFactory.getLogger(TimestampTest.class);

    @Test
    public void show1(){
        Date date=new Date(1672006834339L);
        Timestamp timestamp=new Timestamp(date.getTime());
        log.info("{}",timestamp);//2022-12-26T06:20:34.339+0800
    }
}
