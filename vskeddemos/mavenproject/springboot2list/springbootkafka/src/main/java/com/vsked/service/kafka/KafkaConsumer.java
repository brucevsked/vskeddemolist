package com.vsked.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {
	
    @KafkaListener(topics = "mytopica01a")
    public void onMessage(String mymsg) {
        System.out.println("-------------------|"+mymsg+"|-------------");
    }

}
