package com.jat.java.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 它代表的是不含日期的时间 15:38:40.373
 */
public class LocalTimeTest {

    private static final Logger log = LoggerFactory.getLogger(LocalTimeTest.class);

    @Test
    public void now(){
        LocalTime currentTime=LocalTime.now();
        log.info("{}",currentTime);//15:38:40.373
    }

    @Test
    public void customize(){
        String dateStr="11:35:05";
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime myTime=LocalTime.parse(dateStr,dtf);
        log.info("{}",myTime);//11:35:05
    }

    @Test
    public void format(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HHmmss.SSS");
        LocalTime curTime=LocalTime.now();
        String curTimeStr=curTime.format(dtf);
        log.debug("{}",curTimeStr);
    }

}
