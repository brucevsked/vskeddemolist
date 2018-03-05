package com.vsked.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogService {
	
	private static final Logger logger = LoggerFactory.getLogger(LogService.class);
	
	public static void testLog(){
		Random r=new Random();
		logger.trace("trace "+r.nextDouble());
		logger.debug("debug "+r.nextDouble());
		logger.info("info "+r.nextDouble());
		logger.warn("warn "+r.nextDouble());
		logger.error("error "+r.nextDouble());
	}
	

}
