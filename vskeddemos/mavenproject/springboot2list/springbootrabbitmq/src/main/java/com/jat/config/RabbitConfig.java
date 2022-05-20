package com.jat.config;

import com.jat.user.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    private static final Logger log = LoggerFactory.getLogger(RabbitConfig.class);

    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private StoreService storeService;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        // 消息是否成功发送到Exchange
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.info("消息成功发送到Exchange");
                String msgId = correlationData.getId();
                storeService.updateStoreState(msgId+"_db",1);
                storeService.updateStoreState(msgId+"_cache",1);
            } else {
                log.info("消息发送到Exchange失败, {}, cause: {}", correlationData, cause);
            }
        });

        // 触发setReturnsCallback回调必须设置mandatory=true, 否则Exchange没有找到Queue就会丢弃掉消息, 而不会触发回调
        rabbitTemplate.setMandatory(true);
        // 消息是否从Exchange路由到Queue, 注意: 这是一个失败回调, 只有消息从Exchange路由到Queue失败才会回调这个方法
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                String exchange=returnedMessage.getExchange();
                String routingKey=returnedMessage.getRoutingKey();
                int replyCode=returnedMessage.getReplyCode();
                String replyText=returnedMessage.getReplyText();
                Message message=returnedMessage.getMessage();
                log.info("消息从Exchange路由到Queue失败: exchange: {}, route: {}, replyCode: {}, replyText: {}, message: {}", exchange, routingKey, replyCode, replyText, message);
            }
        });

        return rabbitTemplate;
    }

    @Bean
    public Queue dbQueue() {
        return new Queue(ProjectConfig.DB_QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange dbExchange() {
        return new DirectExchange(ProjectConfig.DB_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Binding dbBinding() {
        return BindingBuilder.bind(dbQueue()).to(dbExchange()).with(ProjectConfig.DB_ROUTING_KEY_NAME);
    }

    @Bean
    public Queue cacheQueue() {
        return new Queue(ProjectConfig.CACHE_QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange cacheExchange() {
        return new DirectExchange(ProjectConfig.CACHE_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Binding cacheBinding() {
        return BindingBuilder.bind(cacheQueue()).to(cacheExchange()).with(ProjectConfig.CACHE_ROUTING_KEY_NAME);
    }
}
