package com.vsked.lesson2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class UdpClient1 {
	
	private static final Logger log = Logger.getLogger(UdpClient1.class);
			
	public static void main(String[] args) {
		try{
        int port = 5858;
		DatagramSocket client = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("127.0.0.1");
		Scanner sc=new Scanner(System.in);
		String sendStr="";
		byte[] sendBuf;
		while(true){
        sendStr = sc.nextLine();
        sendBuf = sendStr.getBytes("utf-8");
        DatagramPacket sendPacket = new DatagramPacket(sendBuf ,sendBuf.length , addr , port);
        client.send(sendPacket);
        System.out.println("client send|"+sendStr);
        if("exit".equals(sendStr)){
        	client.close();
        }
		}
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}
