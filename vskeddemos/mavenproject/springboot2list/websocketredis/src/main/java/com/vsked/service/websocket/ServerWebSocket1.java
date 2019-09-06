package com.vsked.service.websocket;


import io.netty.handler.codec.http.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.yeauty.annotation.*;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;
import com.vsked.common.SysConstant;
import java.io.IOException;
import java.util.Map;


@Slf4j
@Component
@ServerEndpoint(prefix = "websocketservera")
public class ServerWebSocket1 {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, ParameterMap parMap) throws IOException {
        log.info("open|"+session.id());
        String token=parMap.getParameter("token");
        log.info("token:"+token+"|");
        SysConstant.webSocketSessionMap.put(token, session);
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        log.info("close|"+session.id());
        for(Map.Entry<String, Session> dataMap:SysConstant.webSocketSessionMap.entrySet()){
        	if(dataMap.getValue().id().equals(session.id())){
        		SysConstant.webSocketSessionMap.remove(dataMap.getKey());
        		log.info("下线 onclose|"+dataMap.getKey());
        	}
        }        
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("websocket error|"+session.id());
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        log.info("onMessage|"+session.id()+"|"+msg);
        System.out.println("第一步ok");
        //第一步过来消息以后将消息送到redis中去触发监听
        redisTemplate.convertAndSend(SysConstant.webSocketChannel, msg);
    }

}
