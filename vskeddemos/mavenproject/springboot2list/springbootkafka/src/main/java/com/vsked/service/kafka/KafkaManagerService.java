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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaManagerService {
	private final Logger log = LoggerFactory.getLogger(KafkaManagerService.class);
	public static final String myListenerId="myListeneraaa";
	public static Map<String,KafkaMessageListenerContainer<String, String>> topicListenerList=new HashMap<String, KafkaMessageListenerContainer<String,String>>();
	
	public static String kafkaServerIp="10.0.193.11:9092";
	
	public static int taskCount=1;
	
	/**
	 * 用来管理kafka的监听器容器启动,停止等操作
	 */
	@Autowired
	KafkaListenerEndpointRegistry registry;
	
	@Autowired
	PersonalService personalService;
	@Autowired
	FootBallService footBallService;
	
	
	public void createKafkaConsume1(String topicname){
        // 创建另一个测试线程，启动后首先暂停10秒然后变更topic订阅
        Runnable runnable = new Runnable() {
            @SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
            public void run() {
                try {
                    
                	Thread.sleep(10000);//10秒后创建消费者
                    
            		Map<String,Object> configs=new HashMap<String, Object>();
            		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaServerIp);
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
	
	/**
	 * 推荐这种方案
	 * @param topicname
	 */
	public void createKafkaConsume2(String topicname){
		//推荐这种方案
        // 创建另一个测试线程，启动后首先暂停10秒然后变更topic订阅
		Map<String,Object> configs=new HashMap<String, Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaServerIp);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "mygrouptest1");
		configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,  "true");
		
		DefaultKafkaConsumerFactory<String, String>  kafkaConsumerFactory=new DefaultKafkaConsumerFactory<String, String>(configs);

		ContainerProperties containerProperties=new ContainerProperties(topicname.split(","));
		MessageListener<String, String> myMsgListner=new MessageListener<String, String>() {

			@Override
			public void onMessage(ConsumerRecord<String, String> record) {
				log.debug("|11||当前监听主题是:"+record.topic()+"|"+record.value()+"|"+record.key()+"|"+record.headers());
				Map<String, Object> inputData=new HashMap<String, Object>();
				inputData.put("count", taskCount);
				inputData.put("value", record.value());
				if(taskCount%2==0) {
					new Thread(new TaskDispatch(personalService, inputData)).start();
				}else {
					new Thread(new TaskDispatch(footBallService, inputData)).start();
				}
				
				log.info("------------------------finish-----------------------------------"+taskCount);
				taskCount++;
			}
		};
		containerProperties.setMessageListener(myMsgListner);
		
		KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer=new KafkaMessageListenerContainer<String, String>(kafkaConsumerFactory,containerProperties);
		kafkaMessageListenerContainer.setBeanName(myListenerId);//这里就是@KafkaListener中的id也就是
		//kafkaMessageListenerContainer.getContainerProperties().setIdleBetweenPolls(1000*60*1);//设置消费者拉取频率 适用于动态主题
		kafkaMessageListenerContainer.setAutoStartup(true);
		
		kafkaMessageListenerContainer.start();
		topicListenerList.put(topicname, kafkaMessageListenerContainer);
		
	}
	
	public String stopKafka(String topicname){
		String rs="停止主题"+topicname;
		KafkaMessageListenerContainer<String, String> tmpList=topicListenerList.get(topicname);
		if(tmpList!=null){
			tmpList.stop();
			topicListenerList.remove(topicname);				
		}
		return rs;
		
	}
	
	public String dynamicCreateMutiConsumer(String topicname) {
		String rs="动态创建多消费者同时消费"+topicname;
		//推荐这种方案
        // 创建另一个测试线程，启动后首先暂停10秒然后变更topic订阅
		Map<String,Object> configs1=new HashMap<String, Object>();
		configs1.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaServerIp);
		configs1.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs1.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs1.put(ConsumerConfig.GROUP_ID_CONFIG, "mygrouptest1lastest");
		configs1.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		configs1.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,  "true");
		
		DefaultKafkaConsumerFactory<String, String>  kafkaConsumerFactory1=new DefaultKafkaConsumerFactory<String, String>(configs1);
		
		ContainerProperties containerProperties1=new ContainerProperties(topicname.split(","));
		MessageListener<String, String> myMsgListner1=new MessageListener<String, String>() {

			@Override
			public void onMessage(ConsumerRecord<String, String> record) {
				log.debug("|第1个最晚的消费:||当前监听主题是:"+record.topic()+"|"+record.value()+"|"+record.key()+"|"+record.headers());
				try {
					Thread.sleep(5000);
					log.info("第1个休息中...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		containerProperties1.setMessageListener(myMsgListner1);
		
		KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer1=new KafkaMessageListenerContainer<String, String>(kafkaConsumerFactory1,containerProperties1);
		kafkaMessageListenerContainer1.setBeanName(myListenerId+1);//这里就是@KafkaListener中的id也就是
		kafkaMessageListenerContainer1.setAutoStartup(true);
		
		kafkaMessageListenerContainer1.start();
		topicListenerList.put(topicname, kafkaMessageListenerContainer1);
		
		Map<String,Object> configs2=new HashMap<String, Object>();
		configs2.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaServerIp);
		configs2.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs2.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs2.put(ConsumerConfig.GROUP_ID_CONFIG, "mygrouptest2earliest");
		configs2.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		configs2.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,  "true");
		
		DefaultKafkaConsumerFactory<String, String>  kafkaConsumerFactory2=new DefaultKafkaConsumerFactory<String, String>(configs2);
		
		ContainerProperties containerProperties2=new ContainerProperties(topicname.split(","));
		MessageListener<String, String> myMsgListner2=new MessageListener<String, String>() {

			@Override
			public void onMessage(ConsumerRecord<String, String> record) {
				log.debug("|第2个最早的消费:||当前监听主题是:"+record.topic()+"|"+record.value()+"|"+record.key()+"|"+record.headers());
				try {
					Thread.sleep(5000);
					log.info("第2个休息中...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		containerProperties2.setMessageListener(myMsgListner2);
		
		KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer2=new KafkaMessageListenerContainer<String, String>(kafkaConsumerFactory2,containerProperties2);
		//kafkaMessageListenerContainer2.getContainerProperties().setIdleBetweenPolls(1000*60*1);//设置消费者拉取频率 适用于动态主题
		kafkaMessageListenerContainer2.setAutoStartup(true);
		kafkaMessageListenerContainer2.setBeanName(myListenerId+2);//这里就是@KafkaListener中的id也就是
		kafkaMessageListenerContainer2.start();
		topicListenerList.put(topicname, kafkaMessageListenerContainer2);
		
		return rs;
	}


}
