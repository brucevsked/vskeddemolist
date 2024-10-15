package com.vsked.test;

import com.vsked.util.DateTimeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class DateTimeUtilTest {

    private static final Logger log= LogManager.getLogger(DateTimeUtil.class);

    @Test
    public void getMonthLastDay(){
        String FORMATE_DATE = "dd";
        String s="";
        for(int i=1;i<13;i++){
            DateTime dt=new DateTime(2017, i, 1, 0,0);
            s=i+"";
            System.out.println((s.length()==1?"0"+s:s)+" "+dt.dayOfMonth().withMaximumValue().toString(FORMATE_DATE));
            log.debug((s.length()==1?"0"+s:s)+" "+dt.dayOfMonth().withMaximumValue().toString(FORMATE_DATE));
        }
    }

    @Test
    public void curDateCompare(){
        String f="yyyy-MM-dd HH:mm:ss";
//		SimpleDateFormat sdf=new SimpleDateFormat(f);
        String s="2018-10-16 09:07:00";
//		s=sdf.format(new Date());
        log.debug(s);
        DateTime d1= DateTimeUtil.strToDate(s, f);

        boolean b1 = d1.isAfterNow();
        boolean b2 = d1.isBeforeNow();
        log.debug("是否超过当前时间:"+b1+"|是否在当前时间之前:"+b2);
    }

    @Test
    public void curDateTime(){
        /**
         Instant - 不可变的类，用来表示时间轴上一个瞬时的点
         DateTime - 不可变的类，用来替换JDK的Calendar类
         LocalDate - 不可变的类，表示一个本地的日期，而不包含时间部分（没有时区信息）
         LocalTime - 不可变的类，表示一个本地的时间，而不包含日期部分（没有时区信息）
         LocalDateTime - 不可变的类，表示一个本地的日期－时间（没有时区信息）

         作者：JohnShen
         链接：https://www.jianshu.com/p/efdeda608780
         來源：简书
         简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
         */
        String f="yyyy-MM-dd HH:mm:ss";
        LocalDate d1=LocalDate.now();
        log.debug("d1:"+d1);
        LocalTime t1=LocalTime.now();
        log.debug("t1:"+t1);
        LocalDateTime dt1=LocalDateTime.now();
        log.debug("dt1:"+dt1);
        String d2="2018-10-16 09:50:00";
        LocalDateTime dt2=LocalDateTime.parse(d2, DateTimeFormat.forPattern(f));
        log.debug("dt2:"+dt2);
        DateTime dt3=dt2.toDateTime();
        log.debug("dt3"+dt3+"|"+dt3.isAfterNow());
    }

    @Test
    public void localTimeTest(){
        String fmt1="HH:mm";
        LocalTime lt1=LocalTime.now();
        log.debug("|"+lt1.toString(fmt1)+"|");
        String t2="00:50";

        LocalTime lt3=LocalTime.parse(t2);
        log.debug("|"+lt3.toString(fmt1)+"|");

    }

    @Test
    public void getWeek(){
        log.debug(DateTimeUtil.getWeek());
    }

    @Test
    public void databaseTimeToStr(){
        Long instant=new Long("1558041229000");
        DateTime dt=new DateTime(instant);
        log.debug(dt.minusHours(13).toString("yyyy-MM-dd HH:mm:ss"));
    }

}
