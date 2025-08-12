package com.vsked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class PrintLogTest {

    private static final Logger log = LoggerFactory.getLogger(PrintLogTest.class);

    @Test
    public void print(){
        log.trace("pre pare fire");
        log.debug("give me a gun ");
        log.info("now you have a gun");
        log.warn("this is a bad gun");
        log.error("I can't use it");
    }
}
