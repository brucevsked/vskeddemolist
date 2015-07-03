package com.vsked.util;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseLog {
	
	public static void getLog(Class<?> c,Exception e){
		getLogBase(c, e);
	}
	
	public static void getLogWithTransaction(Class<?> c,Exception e){
		getLogBase(c, e);
		//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}
	
	public static void getLogBase(Class<?> c,Exception e){
		Logger  log = LogManager.getLogger(c.getClass());
		log.entry();
		log.debug(c.getName()+"__debug__"+e.getMessage());
		log.info(c.getName()+"__info__"+e.getMessage());
		log.warn(c.getName()+"__warn__"+e.getMessage());
		log.error(c.getName()+"__error__"+e.getMessage());
		log.fatal(c.getName()+"__fatal__"+e.getMessage());
		log.exit();
		e.printStackTrace();
	}
	
	public static void outPutBasicMap(Map<String, String> m){
		Iterator<Entry<String, String>> it=m.entrySet().iterator();	
		while(it.hasNext()){
			Map.Entry<String, String> ent=it.next();
			System.out.println("|"+ent.getKey()+"|"+ent.getValue()+"|");
		}
	}
	
	public static void outPutObject(Object o){
		System.out.println("----------object start--------------");
		System.out.println(o);
		System.out.println("----------object end--------------");
	}

}
