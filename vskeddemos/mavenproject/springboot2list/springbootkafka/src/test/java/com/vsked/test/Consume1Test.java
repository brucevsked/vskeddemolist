package com.vsked.test;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsked.service.kafka.KafkaManagerService;
import org.testng.annotations.Test;

public class Consume1Test {
	
	private final Logger log = LoggerFactory.getLogger(Consume1Test.class);
	
	@Test
	public void t1(){
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaManagerService.kafkaServerIp);
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        p.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        p.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");

        try(KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(p)){
        kafkaConsumer.subscribe(Collections.singletonList(Producer1Test.topic));// 订阅消息
        
        Header data1=null;
        Iterator<Header> it=null;

//        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(100));
            for (ConsumerRecord<String, String> record : records) {
//                log.info(record.value()+"|"+record.timestamp()+"|"+record.partition());
                log.info(record.value()+"|"+record.key()+"|"+record.headers());
                it =record.headers().iterator();
                
                while(it.hasNext()){
                	data1=it.next();
                	log.info(data1.key()+"|"+new String(data1.value()));
                }
            }
//        }
        }catch(Exception e){
        	log.error(e.getMessage(), e);
        }
	}

}
