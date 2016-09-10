package com.vsked.test;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEhcache1 {
	
	/**
	 * get the web-info path 
	 * @return {String} L:/projects/testsession/WebRoot/WEB-INF/
	 */
	public static String getWebInfoPath(){
		String path="";
		path=TestEhcache1.class.getResource("/").toString();
		if(path.startsWith("file:/")){
			path=path.substring(6);
		}
		if(path.endsWith("classes/")){
			path=path.substring(0,path.length()-8);
		}
		//System.out.println(path);
		return path;
	}
	
	public static CacheManager getCacheManager(){
		CacheManager manager = CacheManager.create(getWebInfoPath()+"ehcacheConfig.xml");
		return manager;
	}
	
	public static void init(){
		CacheManager manager = getCacheManager();
		Cache demoCache = manager.getCache("demoCache");
		
		Element cacheElement1=new Element("key_agenta1", "1000");
		demoCache.put(cacheElement1);
		
		Element cacheElement2=new Element("key_agenta2", "2000");
		demoCache.put(cacheElement2);
		
		Element cacheElement3=new Element("key_agenta3", "3000");
		demoCache.put(cacheElement3);
		
		Element cacheElement11=new Element("key_terminala1", "1100");
		demoCache.put(cacheElement11);
		
		Element cacheElement21=new Element("key_terminala2", "2200");
		demoCache.put(cacheElement21);
		
		Element cacheElement31=new Element("key_terminala3", "3100");
		demoCache.put(cacheElement31);
		
				
		System.out.println(demoCache.getSize());
		System.out.println(demoCache.get("key_terminala3"));
		
		Element myElement=demoCache.get("key_terminala3");
		System.out.println((String)myElement.getObjectValue());
		
//		manager.removeCache("demoCache");
		
		
	}
	
	public static String showAllCache(){
		CacheManager manager = getCacheManager();
		Cache demoCache = manager.getCache("demoCache");
		List<?> demoList=demoCache.getKeys();
		for(Object myKey:demoList){
			Element myElement=demoCache.get(myKey);
		    System.out.println(myKey+"|"+myElement.getObjectValue());
		}
		return "ok";
	}
	
	public static void updateCache(String key,String value){
		
		CacheManager manager = getCacheManager();
		Cache demoCache = manager.getCache("demoCache");
		demoCache.remove(key);
		Element cacheElementTmp=new Element(key, value);
		demoCache.put(cacheElementTmp);
		demoCache.put(cacheElementTmp);
		
		
		//showAllCache();
	}
	
	public static void testA1(){
		String key="key_terminala1";
		String value="8000";
		init();
		updateCache(key, value);
		showAllCache();
	}
	
	

	public static void main(String[] args) {
		System.out.println("cacheFile:"+System.getProperty("java.io.tmpdir"));
		CacheManager manager = CacheManager.create("src/ehcacheConfig.xml");
		Cache demoCache = manager.getCache("demoCache");
		
		for(int i=0;i<10000;i++){
			Element cacheElement=new Element("key_"+i, "ppoo00987value"+i);		
			demoCache.put(cacheElement);
		}
		
		System.out.println(demoCache.getSize());
		System.out.println(demoCache.get("key_500"));
		
		Element myElement=demoCache.get("key_500");
		System.out.println((String)myElement.getObjectValue());
		
//		manager.removeCache("demoCache");
		
	}

}
