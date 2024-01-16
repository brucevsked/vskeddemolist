package com.jat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public String hello(String name) {

		if(log.isTraceEnabled()){
			log.trace("start");
		}

		if(log.isDebugEnabled()){
			log.debug(name);
		}

		if(log.isTraceEnabled()){
			log.trace("end");
		}
		return name;
	}

}
