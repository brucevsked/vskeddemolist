package com.jat.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleTest {
    private static final Logger log = LoggerFactory.getLogger(DoubleTest.class);

    @Test
    public void minAndMax(){
        log.debug("min value:{}",Double.MIN_VALUE);
        log.debug("max value:{}",Double.MAX_VALUE);
    }

    @Test
    public void actualValue(){
        double d1=-9999.999;
        double d2=9999.999;
        log.debug("d1 value:{}",d1);
        log.debug("d2 value:{}",d2);
    }

    @Test
    public void stringToDouble(){
        String s="99.0815";
        double d=Double.parseDouble(s);
        log.debug("double value:{}",d);
    }

    @Test
    public void halfUpToInt(){
        double d1=1.883484;
        BigDecimal b1=new BigDecimal(d1);
        int d2=b1.setScale(0, RoundingMode.HALF_UP ).intValue();//四舍五入保留0位小数
        log.debug("result:{}",d2);
    }
}
