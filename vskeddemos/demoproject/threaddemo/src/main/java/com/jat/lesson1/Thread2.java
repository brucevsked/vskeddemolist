package com.jat.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thread2 implements Runnable{

    private static final Logger log = LoggerFactory.getLogger(Thread2.class);

    public void run(){
        if(log.isTraceEnabled()){
            log.trace("start");
        }
        String threadName=Thread.currentThread().getName();

        if(log.isDebugEnabled()){
            log.debug("thread name is:{}",threadName);
        }

        if(log.isTraceEnabled()){
            log.trace("end");
        }

    }
}
