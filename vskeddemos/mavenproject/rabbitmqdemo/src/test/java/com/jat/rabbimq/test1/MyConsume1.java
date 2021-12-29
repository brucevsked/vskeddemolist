package com.jat.rabbimq.test1;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MyConsume1 extends DefaultConsumer {

    private static final Logger log = LoggerFactory.getLogger(MyConsume1.class);

    public MyConsume1(Channel channel) {
        super(channel);
    }

    //5重写消费方法
    /**
     * 消费者接收消息调用此方法
     * @param consumerTag 消费者的标签，在channel.basicConsume()去指定
     * @param envelope 消息包的内容，可从中获取消息id，消息routingkey，交换机，消息和重传标志
    (收到消息失败后是否需要重新发送)
     * @param properties
     * @param body
     * @throws IOException
     * String consumerTag, Envelope envelope, BasicProperties properties, byte[] body
     */
    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        //交换机
        String exchange = envelope.getExchange();
        //路由key
        String routingKey = envelope.getRoutingKey();
        envelope.getDeliveryTag();
        String msg = new String(body,"utf-8");
        log.info("mq收到的消息是:{}",msg );
    }
}
