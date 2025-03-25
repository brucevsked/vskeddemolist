package com.vsked.test.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest {

    private static final Logger log = LoggerFactory.getLogger(DateTimeTest.class);

    public static void main(String[] args) {
        Date nowDate=new Date();

        long validTime=10L*24L*60L*60L*1000L;
        long validTimeDayLong=validTime/1000/60/60/24;
        int validTimeDayInt=Integer.parseInt(validTimeDayLong+"");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.DATE,validTimeDayInt);//add
        Date expireDate=calendar.getTime();

        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        log.info(sdf.format(nowDate));
        log.info(sdf.format(expireDate));
        log.info("after is:{}",expireDate.after(nowDate));
        log.info("before is:{}",expireDate.before(nowDate));


    }
}
