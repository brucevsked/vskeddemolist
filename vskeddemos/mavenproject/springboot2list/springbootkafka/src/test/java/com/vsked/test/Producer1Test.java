package com.vsked.test;

import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer1Test {
	
	public static String topic = "testFlink";// 定义主题,测试时需要修改这个主题

	private final Logger log = LoggerFactory.getLogger(Producer1Test.class);

	@Test
	public void t1() {
		
		Properties p = new Properties();
		p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "bigdata1:9092,bigdata2:9092,bigdata3:9092");// kafka地址，多个地址用逗号分割
		p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(p)) {
//			while (true) {
				String msg = "Hello,hello,hello,hey,hey,这里是我发的消息," + new Random().nextInt(100);
				ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic,"aaa", msg);
				record.headers().add("filename", "yellobook.txt".getBytes());
				kafkaProducer.send(record);
				log.info("消息发送成功hallo11:" + msg);
				Thread.sleep(1500);
//			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
