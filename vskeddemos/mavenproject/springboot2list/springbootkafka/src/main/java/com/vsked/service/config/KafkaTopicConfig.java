package com.vsked.service.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.vsked.service.kafka.TopicTool;

@Configuration
@ConfigurationProperties(prefix = "kafkalistenerlist")
public class KafkaTopicConfig implements InitializingBean{
	
	@Value("topiclist")
	String topiclist;

	public String getTopiclist() {
		return topiclist;
	}

	public void setTopiclist(String topiclist) {
		this.topiclist = topiclist;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("topiclist", TopicTool.topicList);
		System.out.println("here we go-------------------");
	}
	
}
