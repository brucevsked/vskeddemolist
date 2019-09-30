
本示例解决了以下几个问题
1 监控目录时以文件为单位送到kafka
2 送到kafka时添加头信息 文件路径与文件名
3 同名文件后面加下划线与三位数字字母组合防止异常中断
本反序列化器实现了把目录里文件按整个文件读取的功能
flume自定义反序列化器deserializer

第一步打成jar包
第二步将jar包放到lib里
第三步配置flume文件
agent.sources.s1.deserializer= com.vsked.event.LineDeserializer$Builder

参考
https://www.cnblogs.com/yuwenhui/p/9367625.html

自定义sink
第一步flume配置文件中

agent.sources = s1
agent.channels = c1
agent.sinks = k1

# For each one of the sources, the type is defined
agent.sources.s1.type = com.vsked.source.SpoolDirectorySource
agent.sources.s1.spoolDir=/logs/app1/
agent.sources.s1.fileHeader = true
agent.sources.s1.fileHeaderKey = filePath
agent.sources.s1.basenameHeader = true
agent.sources.s1.basenameHeaderKey = fileName
agent.sources.s1.inputCharset= utf-8
agent.sources.s1.deserializer= com.vsked.event.LineDeserializer$Builder
agent.sources.s1.channels = c1
agent.sinks.k1.type = com.vsked.sink.KafkaSink
agent.sinks.k1.topic = mytopica01a
agent.sinks.k1.brokerList = 192.168.127.129:9092
agent.sinks.k1.flumeBatchSize = 20
agent.sinks.k1.requiredAcks = 1
agent.sinks.k1.channel = c1
agent.channels.c1.type = memory
agent.channels.c1.capacity = 100

第二步，将本项目进行打包并放到flume的lib目录中
第三步
在kafka消费者代码中
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
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consume1Test {
	
	private final Logger log = LoggerFactory.getLogger(Consume1Test.class);
	
	@Test
	public void t1(){
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.127.129:9092");
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

取出head中定义的数据即可