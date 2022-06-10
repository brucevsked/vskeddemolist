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
public class StoreToDBImpl {
    private static final Logger logger = LoggerFactory.getLogger(StoreToDBImpl.class);
    @Autowired
    StringRedisTemplate redisTemplate;

    String saveFlag="db_savec";

    @RabbitListener(queues = ProjectConfig.DB_QUEUE_NAME)
    public void consumeWrite(Message message, Channel channel) throws IOException {
        logger.info("###################################向数据库里面写数据啦");
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
            // 消息的标识，false只确认当前一个消息收到，true确认所有consumer获得的消息（成功消费，消息从队列中删除 ）
            channel.basicAck(tag, false);
            logger.info(msgId + ":用户保存到数据库成功"+user);
        } catch (MessagingException e) {
            // ack返回false，requeue-true并重新回到队列
            channel.basicNack(tag, false, true);
            e.printStackTrace();
            logger.error("用户保存到数据库失败：" + e.getMessage()+""+user);
        }
    }

    @RabbitListener(queues = ProjectConfig.DB_READ_QUEUE_NAME)
    public Object consumeRead(Message message, Channel channel) throws IOException {
        logger.info("###################################从数据库里面读数据啦");
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
