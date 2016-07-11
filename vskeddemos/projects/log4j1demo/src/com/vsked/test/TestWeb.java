package com.vsked.test;

import org.apache.log4j.Logger;


public class TestWeb {
	private static Logger log = Logger.getLogger(TestWeb.class);
	
	public void writeLog(){
		log.debug("webdebug msg");
		log.info("webinfo msg");
		log.warn("webwarn msg");
		log.error("weberror msg");
		log.fatal("webfatal msg");
	}

}
