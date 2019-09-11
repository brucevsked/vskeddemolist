package com.vsked.controller;


import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsked.service.kafka.KafkaConsumer;
import com.vsked.service.kafka.KafkaManagerService;

@Controller
public class TestController {
	
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
		if("1".equals(tp)){
			System.out.println("修改主题为11");
			rs="修改主题为11";			
		}else{
			System.out.println("修改主题为22");
			//topics
			ContainerProperties cp=registry.getListenerContainer(KafkaConsumer.myListenerId).getContainerProperties();
			String[] topicArray=cp.getTopics();
			for(String topic:topicArray){
				System.out.println("主题有:"+topic);
			}
			rs="修改主题为22";
			if(topicname==null || "".equals(topicname.trim())){
				topicname="defaulttopic";
			}
			//根据请求参数动态创建,可以向里面传值
			kafkaManagerService.createKafkaConsume1(topicname);

		}
		return rs;
		
	}

}
