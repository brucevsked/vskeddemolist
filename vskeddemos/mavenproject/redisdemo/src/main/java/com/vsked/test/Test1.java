package com.vsked.test;

import redis.clients.jedis.Jedis;

public class Test1 {

	public static void main(String[] args) {
		String host="192.168.1.74";
		int port=6379;
		String password="hyfdrediss1_c99";
		Jedis jedis=new Jedis(host, port);
		jedis.auth(password);
		
		jedis.set("testkey", "testvalue");
		String value=jedis.get("testkey");
		System.out.println(value);

	}

}
