package com.jat.user;

import com.jat.config.ProjectConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class StoreToCacheImpl {
    private static final Logger logger = LoggerFactory.getLogger(StoreToCacheImpl.class);
    @Autowired
    StringRedisTemplate redisTemplate;

    String saveFlag="cache_saved";

    @RabbitListener(queues = ProjectConfig.CACHE_QUEUE_NAME)
    public void consumeWrite(Message message, Channel channel) throws IOException {
        logger.info("----------------------------------向缓存里面写数据啦");
        User user = (User) message.getPayload();
        MessageHeaders headers = message.getHeaders();
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) headers.get("spring_returned_message_correlation");
        if (redisTemplate.opsForHash().entries(saveFlag).containsKey(msgId)) {
            //redis 中包含该 key，说明该消息已经被消费过
            logger.info(msgId + ":消息已经被消费");
            channel.basicAck(tag, false);//确认消息已消费
            return ;
        }
        //收到消息，存储到数据库
        try {
            redisTemplate.opsForHash().put(saveFlag, msgId, user.toString());
            channel.basicAck(tag, false);
            logger.info(msgId + ":用户保存到缓存成功"+user);
        } catch (MessagingException e) {
            channel.basicNack(tag, false, true);
            e.printStackTrace();
            logger.error("用户保存到缓存失败：" + e.getMessage()+""+user);
        }

    }


    @RabbitListener(queues = ProjectConfig.CACHE_READ_QUEUE_NAME)
    public Object consumeRead(Message message, Channel channel) throws IOException {
        logger.info("----------------------------------从缓存里面读数据啦");
        Object tmpObject=message.getPayload();
        if(tmpObject instanceof String){
            String queryType= (String) tmpObject;
            logger.info("查询类型为:{}",queryType);
            MessageHeaders headers = message.getHeaders();
            Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
            String msgId = (String) headers.get("spring_returned_message_correlation");
            msgId=msgId.replace("query","");
            Object user=redisTemplate.opsForHash().get(saveFlag,msgId);
            channel.basicAck(tag, false);//确认消息已消费
            return user;
        }
        return null;
    }
}
