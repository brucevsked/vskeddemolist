package com.vsked.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;

public class BaseTest {
	
	private static final Logger log = Logger.getLogger(BaseTest.class);
	
	@Before
	public void initLog4j(){
        try {
        	String configFile=ExcelUtilTest.class.getResource("/").toString();
        	configFile=configFile.replace("file:/", "");
        	configFile=configFile.replace("test-classes/", "classes/"); //for maven+junit+log4j
        	configFile+="properties/log4j.properties";
        	PropertyConfigurator.configure(configFile);  
        } catch (Exception ex) {  
            System.err.println("Cannot Initialize log4j");  
        } 
	}
}
