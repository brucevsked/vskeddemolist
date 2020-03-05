package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vsked.service.kafka.KafkaManagerService;

@Controller
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	KafkaListenerEndpointRegistry registry;
	
	@Autowired
	KafkaManagerService kafkaManagerService;
	
	
	@RequestMapping("/topicedit")
	@ResponseBody
	public String kafkatopicedit(HttpServletRequest req){
		String rs="0000000";
		String tp=req.getParameter("tp");
		String topicname=req.getParameter("topicname");
		
		
		//topics
		ContainerProperties cp=null;
		String[] topicArray=null;
		MessageListenerContainer mlc=registry.getListenerContainer(KafkaManagerService.myListenerId);
		if(mlc!=null){
			cp=mlc.getContainerProperties();
			topicArray=cp.getTopics();
			for(String topic:topicArray){
				log.info("新创建当前主题有:"+topic);
			}
		}

		
		if("1".equals(tp)){
			log.info("修改主题为|"+topicname);
			rs="推荐方案修改主题为|"+topicname;
			kafkaManagerService.createKafkaConsume2(topicname);
		}else if("2".equals(tp)){
			log.info("修改主题为|"+topicname);
			rs="此方案已不使用修改主题为|"+topicname;
//			if(topicname==null || "".equals(topicname.trim())){
//				topicname="defaulttopic";
//			}
//			//根据请求参数动态创建,可以向里面传值
//			kafkaManagerService.createKafkaConsume1(topicname);

		}else if("3".equals(tp)){
			log.info("停止主题"+topicname);
			rs=kafkaManagerService.stopKafka(topicname);

		}else if("4".equals(tp)) {
			log.info("多个不同类型消费者同时消费一个主题下一条消息"+topicname);
			rs=kafkaManagerService.dynamicCreateMutiConsumer(topicname);
		}
		
		return rs;
		
	}

}
