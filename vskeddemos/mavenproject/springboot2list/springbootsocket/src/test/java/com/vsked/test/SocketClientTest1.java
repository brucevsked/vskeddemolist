package com.vsked.test;

import java.io.OutputStream;
import java.net.Socket;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SocketClientTest1 {
	
	private static final Logger log = LoggerFactory.getLogger(SocketClientTest1.class);
	
	@Test
	public void testSend(){
		try{
			String hostName="192.168.111.71";
			int port=9333;
			String msg="hey hey give me girl";
			Socket client = new Socket(hostName, port);
			client.setKeepAlive(true);
			client.setTcpNoDelay(true);
			
			OutputStream outputStream=client.getOutputStream();
			outputStream.write(msg.getBytes("utf-8"));
			outputStream.flush();
			
			outputStream.close();
			client.close();
		
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}
	

}
