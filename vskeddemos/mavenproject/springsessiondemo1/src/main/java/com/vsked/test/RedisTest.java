package com.vsked.test;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
		String host="192.168.1.74";
		int port=6379;
		String password="hyfdrediss1_c99";
		Jedis jedis=new Jedis(host, port);
		jedis.auth(password);
		
		setGet(jedis);
        getAllData(jedis);
	}
	
	
	public static void getAllData(Jedis j){
		Set keys=j.keys("*"); //列出所有的key，查找特定的key如：redis.keys("foo")
		Iterator it=keys.iterator();
		while(it.hasNext()){
			Object obj=it.next();   
			System.out.println(obj+""+j.get((String)obj));
		}
	}

	public static void setGet(Jedis j){
		j.set("testkey", "testvalue");
		String value=j.get("testkey");
		System.out.println(value);
	}
}
