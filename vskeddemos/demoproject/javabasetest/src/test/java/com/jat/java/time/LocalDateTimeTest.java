package com.jat.java.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 它包含了日期及时间，不过还是没有偏移信息或者说时区。 2022-09-23T15:41:48.368
 */
public class LocalDateTimeTest {

    private static final Logger log = LoggerFactory.getLogger(LocalDateTimeTest.class);

    @Test
    public void now(){
        LocalDateTime currentDateTime=LocalDateTime.now();
        log.info("{}",currentDateTime);//2022-09-23T15:41:48.368
    }

    @Test
    public void customize1(){
        String dateStr="1988-02-01 11:35:05";
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime myDate=LocalDateTime.parse(dateStr,dtf);
        log.info("{}",myDate);//1988-02-01
    }

    @Test
    public void customize2(){
        LocalDateTime myDate=LocalDateTime.of(2022,9,21,12,28);
        log.info("{}",myDate);
    }

    @Test
    public void customize3(){
        String s1="c,250423,135729.902,5,A,8,36.65351095237262,E,117.12227328870772,N,93,50,90,6,28,18,1,2,3,4,5,6,7,8,c001,3,a";
        String[] s1Array=s1.split(",");
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddMMyyHHmmss.SSS");
        LocalDateTime myDate=LocalDateTime.parse(s1Array[1]+s1Array[2],dtf);
        log.info("{}",myDate);//2022-12-26T06:20:34.339+0800
    }

    @Test
    public void plus(){
        LocalDateTime currentDateTime=LocalDateTime.now();
        log.info("{}",currentDateTime);
        LocalDateTime add1Year=currentDateTime.plusYears(1);
        log.info("{}",add1Year);

        LocalDateTime add2Year=currentDateTime.plus(2,ChronoUnit.YEARS);
        log.info("{}",add2Year);

        int defaultExpireTime=1000*60*60*24*1;//1000毫秒,60秒,60分,24小时,1天
        LocalDateTime add1Day=currentDateTime.plus(defaultExpireTime,ChronoUnit.MILLIS);
        log.info("{}",add1Day);
    }

    @Test
    public void minus(){
        LocalDateTime currentDateTime=LocalDateTime.now();
        log.info("{}",currentDateTime);
        LocalDateTime minus1Year=currentDateTime.minusYears(1);
        log.info("{}",minus1Year);

        LocalDateTime minus2Year=currentDateTime.minus(2,ChronoUnit.YEARS);
        log.info("{}",minus2Year);

        int defaultExpireTime=1000*60*60*24*1;//1000毫秒,60秒,60分,24小时,1天
        LocalDateTime minus1Day=currentDateTime.minus(defaultExpireTime,ChronoUnit.MILLIS);
        log.info("{}",minus1Day);
    }

}
