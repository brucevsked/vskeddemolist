package com.vsked.test;

import java.net.InetSocketAddress;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.spy.memcached.MemcachedClient;

public class Memcached1Test {
	private static final Logger log = LoggerFactory.getLogger(Memcached1Test.class);
	
	@Test
	public void connectAndClose(){
		try{
		String ip="127.0.0.1";
		int port=11211;
		MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress(ip, port));
		log.debug("连接成功");
		memcachedClient.add("mykey1", 5000, "valueaaa");//exptime以秒为单位，0 表示永远
		memcachedClient.add("mykey2", 5000, "valuebbb");
		
		String s1=memcachedClient.get("mykey1")+"";
		log.debug(s1);
		String s2=memcachedClient.get("mykey2")+"";
		log.debug(s2);
		memcachedClient.delete("mykey2");
		s2=memcachedClient.get("mykey2")+"";
		log.debug("|"+s2+"|");
		memcachedClient.replace("mykey1", 500, "ccccc5");
		s1=memcachedClient.get("mykey1")+"";
		log.debug(s1);
		
		log.debug(memcachedClient.getName());
		memcachedClient.shutdown();
		log.debug("断开连接");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
