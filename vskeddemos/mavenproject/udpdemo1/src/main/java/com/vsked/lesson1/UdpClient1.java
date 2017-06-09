package com.vsked.lesson1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.log4j.Logger;

public class UdpClient1 {
	
	private static final Logger log = Logger.getLogger(UdpClient1.class);
			
	public static void main(String[] args) {
		try{
		DatagramSocket client = new DatagramSocket();
        String sendStr = "你想发送什么，就向这里写点吧！";
        byte[] sendBuf;
        sendBuf = sendStr.getBytes("utf-8");
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        int port = 5858;
        DatagramPacket sendPacket = new DatagramPacket(sendBuf ,sendBuf.length , addr , port);
        client.send(sendPacket);
        byte[] recvBuf = new byte[100];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf , recvBuf.length);
        client.receive(recvPacket);
        String recvStr = new String(recvPacket.getData() , 0 ,recvPacket.getLength());
        System.out.println("收到:" + recvStr);
        client.close();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
