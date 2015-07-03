package com.vsked.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j1 {

	static Logger log = Logger.getLogger(TestLog4j1.class);

	public static void initConfig() {
		// log4jconfig.properties
		String connectdir = TestLog4j1.class.getResource("/log4jconfig.properties").getPath();
		PropertyConfigurator.configure(connectdir);
		System.out.println(connectdir);

	}

	public static void main(String[] args) {
		initConfig();
		log.debug("debug msg");
		log.info("info msg");
		log.warn("warn msg");
		log.error("error msg");
		log.fatal("fatal msg");

	}

}
