package com.vsked.mail;

import java.util.Properties;   

import javax.mail.FetchProfile;   
import javax.mail.Folder;   
import javax.mail.Message;   
import javax.mail.Session;   
import javax.mail.Store;   
import javax.mail.internet.InternetAddress;   
  
public class Receive    
{   
    public Receive()   
    {   
           
    }   
       
    public static void main(String[] args)   
    {   
        receive();   
    }   
       
    public static void receive()   
    {   
        try    
        {      
            Properties props = new Properties();      
            Session s = Session.getInstance(props);      
            Store store = s.getStore("pop3");      
               
            //对应改成自己的用户名和密码   
            //------------接收邮件的邮箱服务器,用户名,密码
            store.connect("pop.163.com", "用户名", "密码");      
     
            Folder folder = store.getFolder("Inbox");      
            folder.open(Folder.READ_WRITE);      
     
            FetchProfile profile = new FetchProfile();      
            profile.add(FetchProfile.Item.ENVELOPE);      
            Message arraymessage[] = folder.getMessages();      
            folder.fetch(arraymessage, profile);      
     
            System.out.println("收件箱的邮件数：" + arraymessage.length);      
            for (int i = 0; i < arraymessage.length; i++)    
            {      
                //邮件发送者      
                String from = arraymessage[i].getFrom()[0].toString();      
                InternetAddress ia = new InternetAddress(from);      
                   
                System.out.println("******" + i + "******");   
                   
                System.out.println("From:" + ia.getPersonal() + '(' + ia.getAddress() + ')');      
                   
                //邮件标题      
                System.out.println("Title:" + arraymessage[i].getSubject());      
                   
                //邮件大小      
                System.out.println("Size:" + arraymessage[i].getSize());      
                   
                //邮件发送时间      
                System.out.println("Date:" + arraymessage[i].getSentDate());     
            }      
     
            folder.close(false);      
               
            store.close();      
               
        } catch (Exception ee) {      
            ee.printStackTrace();      
        }      
    }   
}  

