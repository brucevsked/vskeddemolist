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
	
	
	public void createKafkaConsume1(String topicname){
        // 创建另一个测试线程，启动后首先暂停10秒然后变更topic订阅
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    
                	Thread.sleep(10000);//10秒后创建消费者
                    
            		Map<String,Object> configs=new HashMap();
            		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.60.10:9092");
            		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "mygrouptest1");
            		configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
            		configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,  "true");
            		
            		DefaultKafkaConsumerFactory  kafkaConsumerFactory=new DefaultKafkaConsumerFactory(configs);
            		
            		Consumer consumer=kafkaConsumerFactory.createConsumer();
            		consumer.subscribe(Collections.singletonList(topicname));// 订阅消息,多个主题中间用逗号分开
            		
                    Header data1=null;
                    Iterator<Header> it=null;

                    while (true) {
                        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(100));
                        //这里可以根据参数来选择不同的service中方法来处理不同的主题,必须是事先写好的service处理方法
                        for (ConsumerRecord<String, String> record : records) {
                            System.out.println("---当前监听主题是:"+record.topic()+"|"+record.value()+"|"+record.key()+"|"+record.headers());
                            it =record.headers().iterator();
                            
                            while(it.hasNext()){
                            	data1=it.next();
                            	System.out.println(data1.key()+"|"+new String(data1.value()));
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    // swallow it.
                }
            }
        };
        
        new Thread(runnable).start();


	}
	

}
