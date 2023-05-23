package com.vsked.test;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class Producer1Test {
	
	public static String topic = "vskedtopic1";// 定义主题,测试时需要修改这个主题

	private final Logger log = LoggerFactory.getLogger(Producer1Test.class);

	@Test
	public void mutiRecordsTest() {
		//需要将type: single修改为 batch 再测试
		Properties p = new Properties();
		p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.193.11:9092");// kafka地址，多个地址用逗号分割
		p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(p)) {
//			while (true) {
			for(int i=0;i<2;i++) {
				String msg = i+"|"+new Date() +"Hello,hello,hello,hey,hey,这里是我发的消息," + new Random().nextInt(100);

				ProducerRecord<String, String> record = new ProducerRecord<String, String>("vskedtopic1","car"+i, msg);
//				record.headers().add("filename"+i, ("yellobook.txt"+i).getBytes());
				kafkaProducer.send(record);
				log.info("消息发送成功hallo11:" + msg);

			}
//			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Test
	public void oneMessageTest() {
        //需要将type: batch修改为 single再测试
		Properties p = new Properties();
		p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.193.11:9092");// kafka地址，多个地址用逗号分割
		p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(p)) {
			for(int i=0;i<3;i++) {
				String msg = i+"|"+new Date() +"Hello,hello,hello,hey,hey,这里是我发的消息," + new Random().nextInt(100);

				ProducerRecord<String, String> record = new ProducerRecord<String, String>("wtss","car"+i, msg);
				kafkaProducer.send(record);
				log.info("消息发送成功hallo11:" + msg);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}


	@Test
	public void directDataTest() {

		Properties p = new Properties();
		p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.193.11:9092");// kafka地址，多个地址用逗号分割
		p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(p)) {
			String msg="只发送字符串数据:"+new Date();
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic2", msg);
			kafkaProducer.send(record);
			log.info("只发送字符串数据:" + msg);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
