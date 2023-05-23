package com.vsked.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    private static final String topicName = "wtss";

    @KafkaListener(topics = "vskedtopic1")
    public void mutiRecords(ConsumerRecords<String, String> records) {
        //log.debug("{}",records);
        for(ConsumerRecord<String, String> record:records){
            log.debug("-------------------------vskedtopic1");
            log.debug("多个消息当前主题是:" + record.topic());
            log.debug("多消息当前消费出内容:{}" + record.key());
            log.debug("多消息当前消费出内容:{}" + record.value());
        }

    }

    @KafkaListener(topics = "wtss")
    public void oneMessage(ConsumerRecord<String, String> record) {
        log.debug("-------------------------wtss");
        log.debug("单个消息当前主题是:" + record.topic());
        log.debug("多消息当前消费出内容:{}" + record.key());
        log.debug("单个消息当前消费出内容:{}" + record.value());
    }

    @KafkaListener(topics = "topic2")
    public void directData(String data) {
        log.debug("直接数据当前主题是:topic2");
        log.debug("直接数据当前消费出内容:{}", data);
    }


}
