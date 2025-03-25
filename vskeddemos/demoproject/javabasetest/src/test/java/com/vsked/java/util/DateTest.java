package com.vsked.java.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * java.time.Instant 替换 java.util.Date
 * java.time.LocalDate 替换 java.sql.Date
 */
public class DateTest {

    private static final Logger log = LoggerFactory.getLogger(DateTest.class);

    @Test
    public void create(){
        log.trace("start test create");
        Date date=new Date();
        log.info("当前时间是:{}",date);
    }

    @Test
    public void create1(){
        log.trace("start test create");
        try {
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateformat.parse("2021-08-08");
            log.info("当前时间是:{}", date);
        }catch (Exception e){
            log.error("日期格式化异常");
        }
    }

    @Test
    public void compare(){
        log.trace("start test compare");
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow=new Date();

        int myDay=5;
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(dateNow);
        calendar.add(Calendar.DATE,myDay);
        Date date1=calendar.getTime();//当前时间加5天后
        log.info("时间比较{}<{}:{}",dateformat.format(date1),dateformat.format(dateNow),date1.before(dateNow));
        log.info("时间比较{}>{}:{}",dateformat.format(date1),dateformat.format(dateNow),date1.after(dateNow));

        log.info("时间比较{}<{}:{}",dateformat.format(dateNow),dateformat.format(date1),dateNow.before(date1));
        log.info("时间比较{}>{}:{}",dateformat.format(dateNow),dateformat.format(date1),dateNow.after(date1));
    }

    @Test
    public void add(){
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(dateNow);
        calendar.add(Calendar.SECOND,-10);//当前时间减10秒
        Date date1=calendar.getTime();//当前时间加5天后

        log.debug("当前时间:{}",dateformat.format(dateNow));
        log.debug("当前时间减少10秒:{}",dateformat.format(date1));
    }

    @Test
    public void sqlDateAndUtilDate(){
        Date dateNow=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(dateNow);
        Date d1=calendar.getTime();

        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.debug("util版本当前时间:{}",d1);

        java.sql.Date d2=new java.sql.Date(calendar.getTime().getTime());

        log.debug("sql版本当前时间:{}",d2);

        Instant d3=Instant.now();

        log.debug("推荐time版本当前时间:{}",d3.toString());


    }

}
