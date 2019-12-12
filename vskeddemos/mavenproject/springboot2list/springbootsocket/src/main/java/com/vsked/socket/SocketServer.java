package com.vsked.socket;

import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketServer implements Runnable{
	private static final Logger log = LoggerFactory.getLogger(SocketServer.class);
	
	String port;
	
	public SocketServer(String port) {
		super();
		this.port = port;
	}



	@Override
	public void run() {
		try {
		System.out.println("===============================server start"+port);
		ServerSocket server = new ServerSocket(Integer.parseInt(port));
		while(true) {
			Socket client=server.accept();
			new Thread(new SocketClient(client)).start();
		}
		}catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		
	}

}
