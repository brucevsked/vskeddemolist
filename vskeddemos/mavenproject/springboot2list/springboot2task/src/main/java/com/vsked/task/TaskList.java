package com.vsked.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskList {

    private static final Logger log = LoggerFactory.getLogger(TaskList.class);

    @Scheduled(cron = "0/5 * * * * ?")
    public void task1(){
        try {
            log.info("task start at {}   task name is :{}",new Date(),Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("task error",e);
        }
        log.info("---------------------------task end at {}, task name is:{}",new Date(),Thread.currentThread().getName());

    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void task2(){
        try {
            log.info("||||||||||task start at {}   task name is :{}",new Date(),Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("task error",e);
        }
        log.info("||||||||||||||||||||||||||||||task end at {}, task name is:{}",new Date(),Thread.currentThread().getName());

    }
}
