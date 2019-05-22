package com.vsked.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ListTest {
	
	private static final Logger log = LoggerFactory.getLogger(ListTest.class);
	
	@Test
	public void listChange1(){
		Map<String, Object> dataMap1=new HashMap<String, Object>();
		dataMap1.put("a", "1");
		dataMap1.put("b", "2");
		
		List<Map<String, Object>> dataList=new LinkedList<Map<String,Object>>();
		dataList.add(dataMap1);
		
		log.info("|"+dataList+"|");
		
		for(Map<String, Object> tmpData:dataList){
			tmpData.put("c3", "c3ah");
			tmpData.put("d", "hey you give me one more try");
		}
		log.info("|"+dataList+"|");
	}

}
