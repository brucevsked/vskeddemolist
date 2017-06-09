package com.vsked.lesson1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.log4j.Logger;

public class UdpServer1 {
	
	private static final Logger log = Logger.getLogger(UdpServer1.class);
	
	public static void main(String[] args) {
		try{
	        DatagramSocket  server = new DatagramSocket(5858);
	        byte[] recvBuf = new byte[100];
	        DatagramPacket recvPacket = new DatagramPacket(recvBuf , recvBuf.length);
	        server.receive(recvPacket);
	        String recvStr = new String(recvPacket.getData() , 0 , recvPacket.getLength(),"utf-8");
	        System.out.println("|" + recvStr);
	        int port = recvPacket.getPort();
	        InetAddress addr = recvPacket.getAddress();
	        String sendStr = "这是服务端给出的响应信息";
	        byte[] sendBuf;
	        sendBuf = sendStr.getBytes();
	        DatagramPacket sendPacket = new DatagramPacket(sendBuf , sendBuf.length , addr , port );
	        server.send(sendPacket);
	        server.close();
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
