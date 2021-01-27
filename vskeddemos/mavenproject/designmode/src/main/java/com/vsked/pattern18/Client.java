package com.vsked.pattern18;

/**
 * 观察者模式
 *
 */
public class Client {
    public static void main(String[] args) {
        Message message=new EmailMessage();//邮件   具体的通知
        message.Add(new Observer1());//要通知的人
        message.notice();
    }
}
