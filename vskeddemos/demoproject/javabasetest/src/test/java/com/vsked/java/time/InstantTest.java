package com.vsked.java.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

/**
 * 代表的是时间戳 2022-09-23T07:16:18.905Z
 */
public class InstantTest {

    private static final Logger log = LoggerFactory.getLogger(InstantTest.class);

    @Test
    public void now(){
        Instant currentDateTime=Instant.now();
        log.info("{}",currentDateTime);//2022-09-23T07:16:18.905Z
    }

    @Test
    public void plus(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.CHINA).withZone(ZoneId.systemDefault());
        Instant currentDateTime=Instant.now();
        log.info("{}",formatter.format(currentDateTime));
        Instant dateTime2=currentDateTime.plus(2, ChronoUnit.HOURS);
        log.info("{}",formatter.format(dateTime2));
    }

    @Test
    public void instantToDate(){
        String dateTime="2023-02-15T10:09:08.123Z";
        log.info("{}",dateTime);
        Instant date1=Instant.parse(dateTime);
        Date date2=new Date(date1.toEpochMilli());
        log.info("{}",date2);
    }

    @Test
    public void stringToInstant(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = "2023-03-16 11:00:02";
        TemporalAccessor temporalAccessor = formatter.parse(timestamp);
        LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        Instant result = Instant.from(zonedDateTime);
        log.info("{}",result);
    }

    @Test
    public void todayStart(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00").withZone(ZoneId.systemDefault());
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        Instant currentDateTime=Instant.now();
        String currentFormat=formatter.format(currentDateTime);
        log.info("{}",currentFormat);
        TemporalAccessor temporalAccessor = formatter2.parse(currentFormat);
        LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        Instant result = Instant.from(zonedDateTime);
        Timestamp timestamp = Timestamp.from(result);
        log.debug("{}",timestamp.getTime());
    }


}
