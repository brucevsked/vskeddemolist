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
}
