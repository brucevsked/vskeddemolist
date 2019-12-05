package com.vsked.lettuce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.lettuce.core.pubsub.RedisPubSubListener;

public class MyRedisPubSubListener implements RedisPubSubListener<String, String> {
	
	private static final Logger log = LoggerFactory.getLogger(MyRedisPubSubListener.class);
	
	public void message(String channel, String message) {
        log.info("msg1={} on channel {}",  message, channel);
    }

    public void message(String pattern, String channel, String message) {
        log.info("msg2={} in channel={}",  message, channel);
    }

    public void subscribed(String channel, long count) {
        log.info("sub channel={}, count={}",  channel, count);
    }

    public void psubscribed(String pattern, long count) {
        log.info("psub pattern={}, count={}", pattern, count);
    }

    public void unsubscribed(String channel, long count) {
        log.info("unsub channel={}, count={}",  channel, count);
    }

    public void punsubscribed(String pattern, long count) {
        log.info("punsub channel={}, count={}",  pattern, count);
    }

}
