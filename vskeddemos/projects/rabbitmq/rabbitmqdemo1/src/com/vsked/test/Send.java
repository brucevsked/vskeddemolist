package com.vsked.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
  
public class Send {
    private final static String QUEUE_NAME = "hello";
  
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
  
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!we send the first message def";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
  
        channel.close();
        connection.close();
    }
}
