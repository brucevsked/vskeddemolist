package com.vsked.test;


import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4j2 {
	
	static Logger  log = LogManager.getLogger(TestLog4j2.class);
	
	public static void initConfig() {
		String p=TestLog4j2.class.getResource("/").getPath();
		System.out.println(p);
		p=getWebRoot(p);
		p=p+"log4j2.xml";
		DOMConfigurator.configure(p);
		System.out.println(p);
	}
	
	public static String getWebRoot(String p){
		p=p.startsWith("/")?p.substring(1):p;
		p=p.endsWith("classes/")?p.substring(0,p.length()-8):p;
		return p;		
	}

	public static void main(String[] args) {
		initConfig();
		log.entry();
		log.debug("debug msg");
		log.info("info msg");
		log.warn("warn msg");
		log.error("error msg");
		log.fatal("fatal msg");
		log.exit();
		
	}

}
