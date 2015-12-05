package com.vsked.test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEhcache1 {

	public static void main(String[] args) {
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
