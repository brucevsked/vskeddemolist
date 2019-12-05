package com.vsked.lettuce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.async.RedisPubSubAsyncCommands;

/**
 * ok
 * @author brucevsked
 *
 */
public class SubTest {
	private static final Logger log = LoggerFactory.getLogger(SubTest.class);

	public static void main(String[] args) {
		try {
			String channels = "serverC1";
			log.debug("sub:" + channels);

			RedisURI redisUri = RedisURI.Builder.redis("192.168.111.95").withPassword("Y4yhl9tbf110_").build();
			RedisClient client = RedisClient.create(redisUri);
			StatefulRedisPubSubConnection<String, String> connection = client.connectPubSub();
			connection.addListener(new MyRedisPubSubListener());
			while (true) {
				RedisPubSubAsyncCommands<String, String> sync = connection.async();
				sync.subscribe(channels);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
