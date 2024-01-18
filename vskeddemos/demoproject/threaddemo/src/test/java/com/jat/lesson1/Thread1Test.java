package com.jat.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Thread1Test {

    private static final Logger log = LoggerFactory.getLogger(Thread1Test.class);

    @Test
    public void testRun(){
        log.trace("start test");
        Thread1 thread1=new Thread1();
        thread1.start();
        log.trace("end test");
    }

}
