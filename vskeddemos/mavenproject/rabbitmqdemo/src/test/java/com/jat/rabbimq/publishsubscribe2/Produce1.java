package com.jat.rabbimq.publishsubscribe2;

import com.rabbitmq.client.BuiltinExchangeType;
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

        String host = "10.0.193.11"; //mq服务ip地址
        int port = 5672; //mq client连接端口
        String userName = "test1";//mq登录用户名
        String password = "test1";//mq登录密码
        String virtualHost = "/testhost2";//rabbitmq默认虚拟机名称为“/”，虚拟机相当于一个独立的mq服务器

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

        //声明一个交换机
        String EXCHANGE = "messageChange";

        //通道绑定交换机
        /**
         * 参数明细
         * 1、交换机名称
         * 2、交换机类型，fanout、topic、direct、headers
         */
        channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.FANOUT);

        Random random=new Random();

        String message = new String("生产者发送的消息是邮件"+random.nextInt(1000));//5制作消息
        /**
         * 消息发布方法
         * param1：Exchange的名称，如果没有指定，则使用Default Exchange
         * param2:routingKey,消息的路由Key，是用于Exchange（交换机）将消息转发到指定的消息队列
         * param3:消息包含的属性
         * param4：消息体
         * 这里没有指定交换机，消息将发送给默认交换机，每个队列也会绑定那个默认的交换机，但是不能显示绑定或解除绑定
         * 默认的交换机，routingKey等于队列名称
         */
        //String exchange, String routingKey, BasicProperties props, byte[] body
        channel.basicPublish(EXCHANGE,"",null,message.getBytes("utf-8"));
        log.info("mq消息发送成功！"+message);

        channel.close();
        connection.close();

    }
}
