package com.vsked.test;

import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  
import com.rabbitmq.client.QueueingConsumer;  
  
public class Reqv {
    private final static String QUEUE_NAME = "hello";
  
    public static void main(String[] argv) throws Exception {
  
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
  
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        //开启手工确认[ack]
        channel.basicConsume(QUEUE_NAME, false, consumer);
  
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
            Thread.sleep(10);
            //返回确认状态 
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }  
    }  
}  
