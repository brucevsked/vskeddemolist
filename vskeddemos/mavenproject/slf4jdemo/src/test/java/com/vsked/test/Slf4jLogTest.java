package com.vsked.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsked.common.TraceUtils;

public class Slf4jLogTest {
	
	private static final Logger log = LoggerFactory.getLogger(Slf4jLogTest.class);
	
	@Test
	public void t1(){
		for(int i=0;i<10;i++){
		log.trace("trace test");
		log.debug("debug test");
		log.info("info test");
		log.warn("warn test");
		log.error("error test");
		}
	}
	
	@Test
	public void MDCTest1(){
		TraceUtils.beginTrace();
		
		for(int i=0;i<10;i++){
		log.trace("trace test");
		log.debug("debug test");
		log.info("info test");
		log.warn("warn test");
		log.error("error test");
		}
		TraceUtils.endTrace();
	}
	
	@Test
	public void MDCTest2(){
       String traceId = RandomStringUtils.randomAlphanumeric(8);
       TraceUtils.beginTrace(traceId);
		
		for(int i=0;i<10;i++){
		log.trace("trace test");
		log.debug("debug test");
		log.info("info test");
		log.warn("warn test");
		log.error("error test");
		}
		TraceUtils.endTrace();
	}

}
