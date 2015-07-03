package com.vsked.mail;
import java.util.*;
import javax.mail.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMails {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//------------收件人邮箱要改1
		String tto="1485559892@qq.com"; //收件人
		String ttile="这是俺一个邮件";//邮件标题
		
		String tcontent="邮件的内容也挺重要的";
		
		Properties props=new Properties(); //也可以用 System.getProperties();
		//------------收件人服务器要改2
		props.put("mail.smtp.host", "smtp.qq.com");
		props.put("mail.smtp.auth", "true");//同时通过验证
		
		Session s=Session.getInstance(props); //根据属性新建一个邮件会话
		s.setDebug(true);
		MimeMessage message=new MimeMessage(s);//由邮件会话新建一个消息报对象
		//------------发件人邮箱要改3
		InternetAddress from=new InternetAddress("vsked@163.com");//vsked@163为发件人邮箱
		message.setFrom(from); //设置发件人
		InternetAddress to=new InternetAddress(tto);
		message.setRecipient(Message.RecipientType.TO, to);//设置收件人并设置接收类型为TO
		
		BodyPart mdp=new MimeBodyPart();//新建一个存放邮件内容的BodyPart对象
		mdp.setContent(tcontent, "text/html;charset=gb2312");//给BodyPart设置内容格式编码方式
		
		Multipart mm=new MimeMultipart();//新建一个MimeMultipart对象存放BodyPart对象(可以存放多个)
		mm.addBodyPart(mdp);//将BodyPart放到MimeMultipart中(可以加入多个BodyPart)
		message.setContent(mm);//把mm作为消息对象内容
		message.saveChanges();
		
		message.setSubject(ttile);//设置主题
		message.setText(tcontent);//设置邮件内容
		message.setSentDate(new Date());//设置发信时间
		message.saveChanges();//存储邮件信息
		//设置发送方式 smtp
		Transport transport=s.getTransport("smtp");
		//设置发件服务器 用户名 密码
		//------------发件人用户名密码要改4
		transport.connect("smtp.163.com", "用户名", "密码");
		transport.sendMessage(message, message.getAllRecipients());//发送邮件 第二个参数是所有
		transport.close();
		

	}

}
