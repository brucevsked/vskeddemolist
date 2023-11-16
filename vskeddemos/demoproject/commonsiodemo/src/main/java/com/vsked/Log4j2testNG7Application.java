package com.vsked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class Log4j2testNG7Application {

	private static final Logger log = LoggerFactory.getLogger(Log4j2testNG7Application.class);

	public String hello(String accountName) {
		String currenAccounttName="";

		if(log.isTraceEnabled()){
			log.trace("Log4j2testNG7Application start");
		}

		if(log.isDebugEnabled()){
			log.debug("accountName is:{}",accountName);
		}

		currenAccounttName=accountName;

		if(log.isInfoEnabled()){
			log.info("currentName is:{}",currenAccounttName);
		}

		if(log.isTraceEnabled()){
			log.trace("Log4j2testNG7Application end");
		}

		return currenAccounttName;
	}

}
