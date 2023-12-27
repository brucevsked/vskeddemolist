package com.vsked.demo2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LogTest {

    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        Log log=new Log();
        log.start();
        log.record();
        log.end();
    }

    @Test
    public void logAspectTest(){
        Log log=new Log();
        log.start();
        log.record();
        log.end();
    }
}
