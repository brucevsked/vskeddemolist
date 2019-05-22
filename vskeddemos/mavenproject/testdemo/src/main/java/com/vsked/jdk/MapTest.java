package com.vsked.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapTest {
	
	private static final Logger log = LoggerFactory.getLogger(MapTest.class);
	
	@Test
	public void putAll(){
		Map<String, Object> dataMap1=new HashMap<String, Object>();
		dataMap1.put("a", "a1");
		dataMap1.put("b", "b2");
		dataMap1.put("c", "c3");
		log.info("|"+dataMap1+"|");
		Map<String, Object> dataMap2=new HashMap<String, Object>();
		dataMap2.put("a", "a3");
		dataMap2.put("b1", "b2");
		dataMap2.put("c1", "c3");
		log.info("|"+dataMap2+"|");
		
		dataMap1.putAll(dataMap2);
		log.info("|"+dataMap1+"|");
		
		
	}


}
