package com.vsked.config;

import com.vsked.service.websocket.RedisReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.vsked.common.SysConstant;


@Configuration
public class RedisSubListenerConfig {
    //初始化监听器
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(SysConstant.webSocketChannel));
        return container;
    }
    //利用反射来创建监听到消息之后的执行方法
    @Bean
    MessageListenerAdapter listenerAdapter(RedisReceiver redisReceiver) {
    	//第二步监听收到消息后交给监听处理类
        return new MessageListenerAdapter(redisReceiver, "receiveMessage");
    }

    //使用默认的工厂初始化redis操作模板
    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
}
