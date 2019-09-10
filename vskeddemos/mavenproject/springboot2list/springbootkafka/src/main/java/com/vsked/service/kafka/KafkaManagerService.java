package com.vsked.service.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Service;


@Service
public class KafkaManagerService {
	
	/**
	 * 用来管理kafka的监听器容器启动,停止等操作
	 */
	@Autowired
	KafkaListenerEndpointRegistry registry;
	
	
	
	public void createKafkaConsume1(){
		Map<String,Object> configs=new HashMap();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.60.10:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "mygrouptest1");
		configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,  "true");
		
		DefaultKafkaConsumerFactory  kafkaConsumerFactory=new DefaultKafkaConsumerFactory(configs);
		
		Consumer consumer=kafkaConsumerFactory.createConsumer();
		consumer.subscribe(Collections.singletonList("pop99"));// 订阅消息
		consumer.poll(Duration.ofSeconds(500));
		

	}
	

}
