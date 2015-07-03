package com.vsked.test;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class TestRedis {

	public static void main(String[] args) {
		String host="127.0.0.1";
		int port=6379;
		String hostPwd="y4yhl9tbf110";
		Jedis redisConnect=new Jedis(host, port);
		redisConnect.auth(hostPwd);

		for(int i=0;i<10;i++){
			addKeyAndValue(redisConnect, i+"k", i+"v");
		}
		System.out.println("------------------------------");
		delKey(redisConnect, "0k");
		delKey(redisConnect, "3k");
		delKey(redisConnect, "4k");
		
		getAllData(redisConnect);
		
		getKeyTTL(redisConnect,"1k");
		getKeyTTL(redisConnect,"2k");
		

	}
	
	public static void addKeyAndValue(Jedis j,String k,String v){
		j.set(k, v);
	}
	
	public static void getAllData(Jedis j){
		Set keys=j.keys("*"); //列出所有的key，查找特定的key如：redis.keys("foo")
		Iterator it=keys.iterator();
		while(it.hasNext()){
			Object obj=it.next();   
			System.out.println(obj+""+j.get((String)obj));
		}
	}
	
	public static void delKey(Jedis j,String k){
		j.del(k);
	}
	
	public static void getKeyTTL(Jedis j,String k){
		System.out.println(j.ttl(k));
	}
	
	public static void removeKeyTTL(Jedis j,String k){
		System.out.println(j.persist(k));
	}


}
