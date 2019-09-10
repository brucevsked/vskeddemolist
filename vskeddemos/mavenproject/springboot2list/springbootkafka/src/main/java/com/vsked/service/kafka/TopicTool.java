package com.vsked.service.kafka;

import org.springframework.stereotype.Service;

public class TopicTool {
	
	//生产环境放到redis中
	public static String topicList="pop1";
	
    public String[] getTopic(){
    	return topicList.split(",");
    }

}
