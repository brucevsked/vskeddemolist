package com.vsked.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
	
	private static final Logger log = LoggerFactory.getLogger(MyTask.class);
	
	@Scheduled(cron = "0 */1 * * * ?")
	public void cleanLog1DataTask() {
		log.info("one minute|"+new Date()+"|");
	}
	
	@Scheduled(cron = "*/10 * * * * ?")
	public void cleanLog2DataTask() {
		log.info("ten seconds|"+new Date()+"|");
	}

}
