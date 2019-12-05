package com.vsked.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

public class Test1 {
	private static final Logger log = LoggerFactory.getLogger(Test1.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String host="192.168.111.95";
		int port=6379;
		String password="Y4yhl9tbf110_";
		Jedis jedis=new Jedis(host, port);
		jedis.auth(password);
		
		jedis.set("testkey", "testvalue");
		String value=jedis.get("testkey");
		log.debug(value);

	}

}
