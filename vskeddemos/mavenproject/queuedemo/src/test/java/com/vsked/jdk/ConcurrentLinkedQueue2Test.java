package com.vsked.jdk;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueue2Test {
	private static final Logger log = LoggerFactory.getLogger(ConcurrentLinkedQueue2Test.class);
	
	@SuppressWarnings("rawtypes")
	public static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
	
	@SuppressWarnings("unchecked")
	@Test
	public void t1(){
		try{
		Map<String, Object> dataMap=new HashMap<String, Object>();
		
		for(int i=0;i<50;i++){
			new Thread(new giveDataA1()).start();
		}
		
		Thread.sleep(2000);
		
		while(!queue.isEmpty()){
			dataMap=(Map<String, Object>) queue.poll();//取数据
			log.debug("|"+dataMap+"|");
			//此处判断数据库处理结果,也就是影响行数,如果影响行业为0或处理失败发生异常时需要标记为错误订单
		}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	}

}

class giveDataA1 implements Runnable{
	private static final Logger log = LoggerFactory.getLogger(ConcurrentLinkedQueue2Test.class);
	@SuppressWarnings("unchecked")
	@Override
	public void run() {
		Random r=new Random();
		int bg=0;
		Map<String, Object> dataMap=new HashMap<String, Object>();
		bg=r.nextInt();
		dataMap.put("userid", bg+"");
		log.debug("--------"+bg+"----------");
		dataMap.put("username", "ak"+bg);
		dataMap.put("moneytype", "add");
		dataMap.put("money", r.nextFloat()+"");
		ConcurrentLinkedQueue2Test.queue.offer(dataMap);
	}
	
}
