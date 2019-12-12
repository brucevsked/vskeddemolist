package com.vsked.socket;

import java.io.InputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketClient implements Runnable{
	private static final Logger log = LoggerFactory.getLogger(SocketClient.class);
	
	Socket socket = null;
	
	public SocketClient(Socket socket) {
		super();
		this.socket = socket;
	}



	@Override
	public void run() {
		try {
			System.out.println("===============================client start");
		InputStream inputStream=socket.getInputStream();
		byte[] dataByte=new byte[4096];
		int len;
		StringBuffer sb=new StringBuffer();
		while((len=inputStream.read(dataByte))!=-1) {
			sb.append(new String(dataByte,0,len,"utf-8"));
		}
		
		log.debug("get message to websocket|"+sb.toString());
		inputStream.close();
		socket.close();
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
	}

}
