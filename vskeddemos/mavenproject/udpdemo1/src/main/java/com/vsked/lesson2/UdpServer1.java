package com.vsked.lesson2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.log4j.Logger;

public class UdpServer1 {
	
	private static final Logger log = Logger.getLogger(UdpServer1.class);
	
	public static void main(String[] args) {
		try{
	        DatagramSocket  server = new DatagramSocket(5858);
	        byte[] recvBuf = new byte[1024];
	        DatagramPacket recvPacket = new DatagramPacket(recvBuf , recvBuf.length);
	        while(true){
	        server.receive(recvPacket);
	        String recvStr = new String(recvPacket.getData() , 0 , recvPacket.getLength(),"utf-8");
	        System.out.println("server receve|" + recvStr);
	        if("exit".equals(recvStr)){
		        server.close();
	        }
	        }

		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
