package com.jat.user;

import com.jat.config.ProjectConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void save(User user){
        String uid=user.getUid()+"";
        CorrelationData correlationData = new CorrelationData(uid);
        rabbitTemplate.convertAndSend(ProjectConfig.DB_EXCHANGE_NAME, ProjectConfig.DB_ROUTING_KEY_NAME,
                user, correlationData);// 发送消息 持久化到数据库
        rabbitTemplate.convertAndSend(ProjectConfig.CACHE_EXCHANGE_NAME, ProjectConfig.CACHE_ROUTING_KEY_NAME,
                user, correlationData);// 发送消息 持久化到缓存
    }

    public Object read(String uid){
        CorrelationData correlationData = new CorrelationData("query"+uid);
        rabbitTemplate.setDefaultReceiveQueue(ProjectConfig.CACHE_READ_QUEUE_NAME);
        //先读取缓存
        Object user= rabbitTemplate.convertSendAndReceive(ProjectConfig.CACHE_READ_EXCHANGE_NAME, ProjectConfig.CACHE_READ_ROUTING_KEY_NAME,
                "queryUser", correlationData);
        if(user==null){
            rabbitTemplate.setDefaultReceiveQueue(ProjectConfig.DB_READ_QUEUE_NAME);
            //缓存没有再读取数据库
            user= rabbitTemplate.convertSendAndReceive(ProjectConfig.DB_READ_EXCHANGE_NAME, ProjectConfig.DB_READ_ROUTING_KEY_NAME,
                    "queryUser", correlationData);
        }
        return user;
    }
}
