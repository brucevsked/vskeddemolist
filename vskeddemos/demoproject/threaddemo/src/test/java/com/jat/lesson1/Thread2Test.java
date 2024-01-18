package com.jat.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Thread2Test {

    private static final Logger log = LoggerFactory.getLogger(Thread2Test.class);

    @Test
    public void testRun(){
        log.trace("start test");
        Thread2 thread2=new Thread2();
        Thread runThread=new Thread(thread2);
        runThread.start();
        log.trace("end test");
    }
}
