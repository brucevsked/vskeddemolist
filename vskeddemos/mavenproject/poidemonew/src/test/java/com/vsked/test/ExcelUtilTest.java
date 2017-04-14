package com.vsked.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.vsked.util.ExcelUtil;

public class ExcelUtilTest {
	
	private static Logger log = Logger.getLogger(ExcelUtilTest.class);
	
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
	
//	@Test
	public void readExcel03And07(){
		try{
		String filePath="e:/yuante.xlsx";
		long start=System.currentTimeMillis();
		Map<String, List<String[]>> dataMapAll=ExcelUtil.readExcel03And07(filePath);
		long end=System.currentTimeMillis();
		log.debug("|s1|"+(end-start));//1990 ms this method more faster
		
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
	@Test
	public void xssfRead1(){
		try{
		String filePath="e:/yuante.xlsx";
		long start=System.currentTimeMillis();
		Map<String, List<String[]>> dataMapAll=ExcelUtil.xssfRead1(filePath);
		long end=System.currentTimeMillis();
		log.debug("|s2|"+(end-start));//2480 ms this method slow
		
		}catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
//	@Test
	public void t1(){
		log.debug(11);
	}
}
