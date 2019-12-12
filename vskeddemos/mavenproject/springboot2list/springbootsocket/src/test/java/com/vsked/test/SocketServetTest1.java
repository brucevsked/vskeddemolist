package com.vsked.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketServetTest1 {
	private static final Logger log = LoggerFactory.getLogger(SocketServetTest1.class);

	@Test
	public void testReceive(){
		try{
			int port=9333;
			ServerSocket server=new ServerSocket(port);
			
			Socket socket=server.accept();
			InputStream inputStream=socket.getInputStream();
			byte[] dataByte=new byte[4096];
			int len;
			StringBuffer sb=new StringBuffer();
			while((len=inputStream.read(dataByte))!=-1) {
				sb.append(new String(dataByte,0,len,"utf-8"));
			}
			
			log.debug(""+sb.toString());
			inputStream.close();
			socket.close();
			server.close();
		
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}
	
}
