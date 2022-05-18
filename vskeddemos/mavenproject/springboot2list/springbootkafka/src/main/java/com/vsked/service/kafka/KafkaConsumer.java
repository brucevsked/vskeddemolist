package com.vsked.service.kafka;

import java.util.Date;
import java.util.Iterator;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.header.Header;
import org.springframework.context.annotation.DependsOn;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumer {
	
	public static final String myListenerId="myListener1";

	
	/*
    @KafkaListener(topics = "mytopica01a")
    public void onMessage(String mymsg) {
    //方式1只接值
        System.out.println("-------------------|"+mymsg+"|-------------");
    }
    */
	
	/*
    @KafkaListener(topics = "pop1")
    public void onMessage2(ConsumerRecords<String, String> records) {
    	//方式3可以取到头信息 批量
    	Iterator<Header> it=null;
    	Header data1=null;
        for (ConsumerRecord<String, String> record : records) {
//          log.info(record.value()+"|"+record.timestamp()+"|"+record.partition());
        	System.out.println(record.value()+"|"+record.key()+"|"+record.headers());
          it =record.headers().iterator();
          
          while(it.hasNext()){
          	data1=it.next();
          	System.out.println(data1.key()+"|"+new String(data1.value()));
          }
      }
    }
    */
    /*
    @KafkaListener(topics = "pop1")
    public void onMessage1(ConsumerRecord<String, String> record) {
    	//方式2可以取到头信息
    	Iterator<Header> it=null;
    	Header data1=null;
        System.out.println(record.value()+"|"+record.key()+"|"+record.headers());
        it =record.headers().iterator();
        
        while(it.hasNext()){
        	data1=it.next();
        	System.out.println(data1.key()+"|"+new String(data1.value()));
        }
    }
    */

	/*
    @KafkaListener(topics = "#{'${kafkalistenerlist.topiclist}'.split(',')}",id=KafkaConsumer.myListenerId)
    public void onMessage1(ConsumerRecord<String, String> record) {
        //同时监听多个主题
    	System.out.println("当前主题是:"+record.topic());
    }
    */
	
   // @KafkaListener(topics = "#{'${kafkalistenerlist.topiclist}'.split(',')}",id=KafkaConsumer.myListenerId)
    public void onMessage1(ConsumerRecord<String, String> record) {
    	System.out.println("当前主题是:"+record.topic());
    }


    @KafkaListener(topics = "vskedtopic1",containerFactory = "timeBatchFactory")
    public void onMessage2(ConsumerRecord<String, String> record) {
        System.out.println("-------------------------"+new Date());
        System.out.println("当前主题是:"+record.topic());
        System.out.println(""+record.value());

    }
    

}
