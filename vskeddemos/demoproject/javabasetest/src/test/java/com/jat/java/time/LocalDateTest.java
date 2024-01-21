package com.jat.java.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 不包含具体时间的日期，比如 2020-01-14。它可以用来存储生日，周年纪念日，入职日期等
 */
public class LocalDateTest {

    private static final Logger log = LoggerFactory.getLogger(LocalDateTest.class);

    @Test
    public void now(){
        LocalDate currentDate=LocalDate.now();
        log.info("{}",currentDate);//2022-09-23
    }

    @Test
    public void customize(){
        String dateStr="1988-02-01";
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate myDate=LocalDate.parse(dateStr,dtf);
        log.info("{}",myDate);//1988-02-01
    }

    @Test
    public void age(){
        String dateStr="1988-02-01";
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate myDate=LocalDate.parse(dateStr,dtf);
        LocalDate currentDate=LocalDate.now();
        int age=currentDate.getYear()-myDate.getYear();
        log.info("your age is:{}",age);
    }

    @Test
    public void format(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddMMyy");
        LocalDate currentDate=LocalDate.now();
        String myDate=currentDate.format(dtf);
        log.info("{}",myDate);
    }
}
