package com.vsked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrintLog {

    private static final Logger log = LoggerFactory.getLogger(PrintLog.class);
    public static void main(String[] args) {
        log.trace("pre pare fire");
        log.debug("give me a gun ");
        log.info("now you have a gun");
        log.warn("this is a bad gun");
        log.error("I can't use it");
    }
}
