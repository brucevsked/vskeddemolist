package com.jat.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class IntegerTest {
    private static final Logger log = LoggerFactory.getLogger(IntegerTest.class);

    @Test
    public void intToHex(){
        int value=1001;
        log.debug("Integer|{}|",value);
        String hex=Integer.toHexString(value);
        log.debug("hex|{}|",hex);
    }

    @Test
    public void hexToInt(){
        //   884B2
        String hex="a";
        log.debug("hex|{}|",hex);
        Integer value=Integer.parseInt(hex,16);
        log.debug("Integer|{}|",value);
    }

}
