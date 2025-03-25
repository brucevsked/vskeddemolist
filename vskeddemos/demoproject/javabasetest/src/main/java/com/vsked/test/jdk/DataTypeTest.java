package com.vsked.test.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import java.util.Date;

public class DataTypeTest {

    private static final Logger log = LoggerFactory.getLogger(DataTypeTest.class);

    public static void main(String[] args) {
        log.debug("------------------基本数据类型--------------start");
        byte byteMinTest1=Byte.MIN_VALUE;
        log.info("byte 最小值"+byteMinTest1);
        byte byteMaxTest1=Byte.MAX_VALUE;
        log.info("byte 最大值"+byteMaxTest1);

        short shortMinTest1=Short.MIN_VALUE;
        log.info("short 最小值"+shortMinTest1);
        short shortMaxTest1=Short.MAX_VALUE;
        log.info("short 最大值"+shortMaxTest1);

        int intMinTest1=Integer.MIN_VALUE;
        log.info("int 最小值"+intMinTest1);
        int intMaxTest1=Integer.MAX_VALUE;
        log.info("int 最大值"+intMaxTest1);

        long longMinTest1=Long.MIN_VALUE;
        log.info("long 最小值"+longMinTest1);
        long longMaxTest1=Long.MAX_VALUE;
        log.info("long 最大值"+longMaxTest1);

        float floatMinTest1=Float.MIN_VALUE;
        log.info("float 最小值{}",floatMinTest1);
        float floatMaxTest1=Float.MAX_VALUE;
        log.info("float 最大值{}",floatMaxTest1);

        double doubleMinTest1=Double.MIN_VALUE;
        log.info("double 最小值"+doubleMinTest1);
        double doubleMaxTest1=Double.MAX_VALUE;
        log.info("double 最大值"+doubleMaxTest1);

        boolean booleanMinTest1=Boolean.TRUE;
        log.info("boolean 真值"+booleanMinTest1);
        boolean booleanMaxTest1=Boolean.FALSE;
        log.info("boolean 假值"+booleanMaxTest1);

        char charTest1='a';
        log.info("char 测试|"+charTest1);


        log.debug("------------------基本数据类型--------------end");

        Timestamp timestampTest1=new Timestamp(Long.parseLong("1600988818888"));
        log.info("Timestamp 测试1|"+timestampTest1);
        Timestamp timestampTest2=new Timestamp(new Date().getTime());
        log.info("Timestamp 测试2|"+timestampTest2);

    }
}
