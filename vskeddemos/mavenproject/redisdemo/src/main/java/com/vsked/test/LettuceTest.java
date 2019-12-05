package com.vsked.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;

public class LettuceTest {
	private static final Logger log = LoggerFactory.getLogger(LettuceTest.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		RedisURI redisUri = RedisURI.Builder.redis("192.168.111.95")
                .withPassword("Y4yhl9tbf110_")
                .build();
		RedisClient client = RedisClient.create(redisUri);
		StatefulRedisConnection<String, String> connection = client.connect();
		RedisStringCommands sync = connection.sync();
		String value = (String) sync.get("testkey");
		log.debug(value);
	}

}
