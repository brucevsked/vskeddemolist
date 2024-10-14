package com.vsked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public String getCurrentOSUserName(){
        return System.getProperty("user.name");
	}



	public void cleanDump(){
		log.info("start clean dump folder");
		String currentOSUserName = getCurrentOSUserName();
		String dumpPath="C:/Users/"+currentOSUserName+"/AppData/Local/CrashDumps";
		log.info("end clean dump folder");
	}

}
