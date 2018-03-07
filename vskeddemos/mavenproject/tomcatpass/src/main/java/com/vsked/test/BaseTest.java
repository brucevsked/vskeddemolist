package com.vsked.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseTest {
	
	private static Logger log = Logger.getLogger(BaseTest.class);
	
	public static void initLog4j(){
        try {
        	String configFile=BaseTest.class.getResource("/").toString();
        	configFile=configFile.replace("file:/", "");
        	configFile=configFile.replace("test-classes/", "classes/"); //for maven+junit+log4j
        	configFile+="properties/log4j.properties";
        	PropertyConfigurator.configure(configFile);  
        } catch (Exception ex) {  
            System.err.println("Cannot Initialize log4j"+ex.getMessage());
            log.error(ex.getMessage());
        } 
	}
	
}
