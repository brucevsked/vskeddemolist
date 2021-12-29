package com.jat.rabbimq.test2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
1、声明队列
2、创建连接
3、创建通道
4、通道声明队列
5、重写消息消费方法
6、执行消息方法
*/
public class Consume2 {
    //异步回调方式

    private static final Logger log = LoggerFactory.getLogger(Consume2.class);

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
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(userName);//mq登录用户名
        connectionFactory.setPassword(password);//mq登录密码
        connectionFactory.setVirtualHost(virtualHost);//rabbitmq默认虚拟机名称为“/”，虚拟机相当于一个独立的mq服务器
        connection = connectionFactory.newConnection();//2 创建连接
        channel = connection.createChannel();//3创建通道

        MyConsume1 myConsumer1 = new MyConsume1(channel);

        boolean autoAck = false;//关闭自动确认，使用手动确认
        channel.basicConsume(queueName,autoAck,myConsumer1);

        log.info("消费者启动成功！");

//        channel.close(); //不关闭，一直连接消费通道
//        connection.close();//不关闭，一直连接服务器


    }
}
