package com.vsked.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class YunZeTask {

    private static final Logger log = LoggerFactory.getLogger(YunZeTask.class);

    @Scheduled(cron = "0/5 * * * * ?")
    public void task1(){
        log.trace("you have enter task1");
        try {
            log.info("task start at {}   task name is :{}",new Date(),Thread.currentThread().getName());
            Thread.sleep(5000);
            log.debug("this is debug level");
            log.warn(" let's go ");
            log.error("my error is no error");

        } catch (InterruptedException e) {
            log.error("task error",e);
        }
        log.info("---------------------------task end at {}, task name is:{}",new Date(),Thread.currentThread().getName());

    }
}
