package com.vsked.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.vsked.util.PortScanner;

public class PortScannerTest {
	
	private static Logger log = Logger.getLogger(PortScannerTest.class);
	
	@Before
	public void initLog4j(){
        try {
        	String configFile=PortScannerTest.class.getResource("/").toString();
        	configFile=configFile.replace("file:/", "");
        	configFile=configFile.replace("test-classes/", "classes/"); //for maven+junit+log4j
        	configFile+="properties/log4j.properties";
        	PropertyConfigurator.configure(configFile);  
        } catch (Exception ex) {  
            System.err.println("Cannot Initialize log4j");
        } 
	}
	
	@Test
	public void isOpen(){
		PortScanner portScanner=new PortScanner();
		String ipAddr="127.0.0.1";
		int port=3389;
		boolean isPortOpen=portScanner.isOpen(ipAddr, port);
		log.debug(isPortOpen);
	}
	
}
