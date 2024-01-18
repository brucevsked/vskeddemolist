package com.jat.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thread1 extends Thread{

    private static final Logger log = LoggerFactory.getLogger(Thread1.class);

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
