package com.vsked.service.websocket;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.yeauty.pojo.Session;
import com.vsked.common.SysConstant;

@Service
public class RedisReceiver {

    public void receiveMessage(String message) {
    	try{
        //第三步监听处理类遍历本地websocket会话列表并发送消息
    	System.out.println("第二步ok"+message);
    	message=message.replace("\\", "");
    	
    	String to=message.substring(message.indexOf("to")+5,message.indexOf("type")-3);
    	System.out.println("|"+to+"|");

        for(Map.Entry<String, Session> toDataMap:SysConstant.webSocketSessionMap.entrySet()){
        	if(toDataMap.getKey().equals(to)){
        		toDataMap.getValue().sendText(message);
        		System.out.println("发出消息用户"+to);
        	}
        }   
        
    	}catch(Exception e){
    		System.out.println("解析数据异常");
    		e.printStackTrace();
    	}
    }
}
