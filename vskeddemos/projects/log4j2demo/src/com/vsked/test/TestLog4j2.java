package com.vsked.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

public class TestLog4j2 {
	
	static Logger  log = LogManager.getLogger(TestLog4j2.class);
	
	public static void initConfig() {
		String p=TestLog4j2.class.getResource("/").getPath();
		System.out.println(p);
		p=getWebRoot(p);
		p=p+"log4j2.xml";
		try {
			Configurator.initialize(null, new ConfigurationSource(new FileInputStream(p)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(p);
	}
	
	public static String getWebRoot(String p){
		p=p.startsWith("/")?p.substring(1):p;
		return p;		
	}

	public static void main(String[] args) {
		initConfig();
		ThreadContext.put("userId", "12");
		ThreadContext.put("userName", "admin");
		log.entry();
		log.debug("debug msg");
		log.info("info msg");
		log.warn("warn msg");
		log.error("error msg");
		log.fatal("fatal msg");
		log.exit();
		
	}

}
