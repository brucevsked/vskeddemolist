package com.vsked.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
	
	private static final String topicName="wtss";


    @KafkaListener(topics = topicName)
    public void onMessage(ConsumerRecord<String, String> record) {
        System.out.println("-------------------------");
        System.out.println("当前主题是:"+record.topic());
        System.out.println("当前消费出内容:{}"+record.value());
    }

        @KafkaListener(topics = "topic2")
    public void onMessage1(String data) {
        System.out.println("-------------------------");
        System.out.println("当前主题是:topic2");
        System.out.println("当前消费出内容:{}",data);
    }
    

}
