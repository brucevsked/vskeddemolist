package com.vsked.jdk;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueue1Test {
	private static final Logger log = LoggerFactory.getLogger(ConcurrentLinkedQueue1Test.class);
	
	@SuppressWarnings("rawtypes")
	ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
	
	@SuppressWarnings("unchecked")
	@Test
	public void t1(){
		
		Map<String, Object> dataMap=new HashMap<String, Object>();
		dataMap.put("userid", "1");
		dataMap.put("username", "ak1");
		dataMap.put("moneytype", "add");
		dataMap.put("money", "80");
		
		queue.offer(dataMap);//添加元素
		
		dataMap=new HashMap<String, Object>();
		dataMap.put("userid", "1");
		dataMap.put("username", "ak1");
		dataMap.put("moneytype", "add");
		dataMap.put("money", "82");
		
		queue.offer(dataMap);//添加元素
		
		
		while(!queue.isEmpty()){
			dataMap=(Map<String, Object>) queue.poll();//取数据
			log.debug("|"+dataMap+"|");
		}
		
		
	}

}
