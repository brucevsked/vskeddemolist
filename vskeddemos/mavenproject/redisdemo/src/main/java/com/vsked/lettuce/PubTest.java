package com.vsked.lettuce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.async.RedisPubSubAsyncCommands;

public class PubTest {
	private static final Logger log = LoggerFactory.getLogger(PubTest.class);
	
	public static void main(String[] args) {
		String channel="serverC1";
		log.debug("pub:"+channel);
		RedisURI redisUri = RedisURI.Builder.redis("192.168.111.95")
                .withPassword("Y4yhl9tbf110_")
                .build();
		RedisClient client = RedisClient.create(redisUri);
		StatefulRedisPubSubConnection<String, String> connection = client.connectPubSub();
		connection.addListener(new MyRedisPubSubListener());
		RedisPubSubAsyncCommands<String, String> sync =  connection.async();
		
		String message="{\"from\":\"client1Token\",\"to\":\"client2Token\",\"type\":\"1\",\"time\":\"20190906140918288\",\"data\":{\"url\":\"/api/hello999999aaaaaa\",\"param\":\"ais\"}}";
		sync.publish(channel, message);
	}

}
