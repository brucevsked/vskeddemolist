package com.vsked.service.config;

import com.vsked.service.kafka.KafkaManagerService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BeanConfig {


    public ConsumerFactory consumerFactory(){
        Map<String,Object> configs2=new HashMap<String, Object>();
        configs2.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaManagerService.kafkaServerIp);
        configs2.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs2.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs2.put(ConsumerConfig.GROUP_ID_CONFIG, "mygrouptest2earliest");
        configs2.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        configs2.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,  "true");

        DefaultKafkaConsumerFactory<String, String> kafkaConsumerFactory2=new DefaultKafkaConsumerFactory<String, String>(configs2);

        return kafkaConsumerFactory2;
    }

    /**
     * 设置消费者拉取频率，适用于固定主题
     * @return
     */
    @Bean("timeBatchFactory")
    public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setIdleBetweenPolls(1000*30*1); //客户端拉取频率
        return factory;
    }
}
