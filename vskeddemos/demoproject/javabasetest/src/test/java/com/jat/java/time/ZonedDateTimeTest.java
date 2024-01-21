package com.jat.java.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


/**
 * 这是一个包含时区的完整的日期时间，偏移量是以 UTC / 格林威治时间为基准的。2022-09-23T15:44:18.324+08:00[Asia/Shanghai]
 */
public class ZonedDateTimeTest {

    private static final Logger log = LoggerFactory.getLogger(ZonedDateTimeTest.class);

    @Test
    public void now(){
        //默认时区
        ZonedDateTime currentZonedDateTime=ZonedDateTime.now();
        log.info("{}",currentZonedDateTime);//2022-09-23T15:44:18.324+08:00[Asia/Shanghai]

        //设置时区
        ZonedDateTime zdt=ZonedDateTime.now(ZoneId.of("America/New_York"));
        log.info("{}",zdt);//2022-09-23T03:51:30.755-04:00[America/New_York]
    }

    @Test
    public void customize(){
        LocalDateTime ldt01=LocalDateTime.of(2022,9,21,12,28);
        ZonedDateTime zdt01=ZonedDateTime.of(ldt01,ZoneId.of("America/New_York"));
        log.info("{}",zdt01);
    }

    @Test
    public void toTimeStamp(){
        ZonedDateTime zdt = ZonedDateTime.now();

        // 1. ZonedDateTime to TimeStamp
        Timestamp timestamp = Timestamp.valueOf(zdt.toLocalDateTime());

        // 2. ZonedDateTime to TimeStamp , no different
        Timestamp timestamp2 = Timestamp.from(zdt.toInstant());

        log.info("{}",zdt); // 2023-04-25T10:45:00.525811300+08:00[Asia/Shanghai]

        log.info("{}",timestamp); // 2023-04-25T10:45:00.525+0800

        log.info("{}",timestamp2); // 2023-04-25T10:45:00.525+0800
    }

    @Test
    public void customize1(){
        String dateStr="1988-02-01 11:35:05";
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        ZonedDateTime zdt=ZonedDateTime.parse(dateStr,dtf);
        log.info("{}",zdt);//1988-02-01T11:35:05+08:00[Asia/Shanghai]
    }

    @Test
    public void customize2(){
        String s1="c,250423,135729.902,5,A,8,36.65351095237262,E,117.12227328870772,N,93,50,90,6,28,18,1,2,3,4,5,6,7,8,c001,3,a";
        String[] s1Array=s1.split(",");
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddMMyyHHmmss.SSS").withZone(ZoneId.systemDefault());
        ZonedDateTime zdt=ZonedDateTime.parse(s1Array[1]+s1Array[2],dtf);
        log.info("{}",zdt);//2023-04-25T13:57:29.902+08:00[Asia/Shanghai]
        Timestamp timestamp = Timestamp.from(zdt.toInstant());
        log.info("{}",timestamp); //2023-04-25T13:57:29.902+0800
        log.info("{}",timestamp.toString()); //2023-04-25 13:57:29.902
        log.info("{}",timestamp.getTime());//1682402249902
                                           //1648432611249000000
        log.info("{}",System.nanoTime());//13303827702700
    }

    @Test
    public void zoneChange(){
        //时区转换
        ZonedDateTime shangHai=ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        log.info("{}", shangHai);//2023-06-19T14:09:08.849834800+08:00[Asia/Shanghai]
        ZoneId zoneId=ZoneId.of("America/New_York");
        ZonedDateTime newYork=shangHai.withZoneSameInstant(zoneId);
        log.info("{}", newYork);//2023-06-19T02:09:08.849834800-04:00[America/New_York]

        ZoneId zoneIdLondon=ZoneId.of("UTC+00:00");
        ZonedDateTime londonZDT=shangHai.withZoneSameInstant(zoneIdLondon);
        log.info("{}", londonZDT);//2023-06-19T06:09:08.849834800Z[UTC]
    }

}
