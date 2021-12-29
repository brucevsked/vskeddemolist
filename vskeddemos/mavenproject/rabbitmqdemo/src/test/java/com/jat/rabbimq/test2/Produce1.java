package com.jat.rabbimq.test2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;


/*
1、声明队列
2、创建连接
3、创建通道
4、通道声明队列
5、制定消息
6、发送消息，使用默认交换机
*/
public class Produce1 {

    private static final Logger log = LoggerFactory.getLogger(Produce1.class);

    public static void main(String[] args) throws Exception {

        String queueName = "myTestQueue1"; //1队列名称
        String host = "10.0.193.11"; //mq服务ip地址
        int port = 5672; //mq client连接端口
        String userName = "test1";//mq登录用户名
        String password = "test1";//mq登录密码
        String virtualHost = "/testhost1";//rabbitmq默认虚拟机名称为“/”，虚拟机相当于一个独立的mq服务器

        Connection connection = null;
        Channel channel = null;

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);//mq服务ip地址
        connectionFactory.setPort(port);//mq client连接端口
        connectionFactory.setUsername(userName);//mq登录用户名
        connectionFactory.setPassword(password);//mq登录密码
        connectionFactory.setVirtualHost(virtualHost);//rabbitmq默认虚拟机名称为“/”，虚拟机相当于一个独立的mq服务器
        connection = connectionFactory.newConnection(); //2创建与RabbitMQ服务的TCP连接
        channel = connection.createChannel(); //3创建与Exchange的通道，每个连接可以创建多个通道，每个通道代表一个会话任务

        //4通道绑定队列
        /**
         * 声明队列，如果Rabbit中没有此队列将自动创建
         * param1:队列名称
         * param2:是否持久化
         * param3:队列是否独占此连接
         * param4:队列不再使用时是否自动删除此队列
         * param5:队列参数
         * String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
         *
         */
        channel.queueDeclare(queueName, true, false, false, null);//通道绑定邮件队列

        Random random=new Random();

        String message = new String("生产者发送的消息是"+random.nextInt(1000));//5制作消息


        channel.basicPublish("", queueName, null, message.getBytes("utf-8"));//6发送消息
        log.info("mq消息发送成功！"+message);

        channel.close();
        connection.close();

    }
}
