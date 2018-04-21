package com.vsked.test.tcp;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer1Test {
	
	private static final Logger log = LoggerFactory.getLogger(TcpServer1Test.class);
	
	@Test
	public void startServer() throws Exception{
		int port=10015;
		ServerSocket server = new ServerSocket(port);
		Socket socket = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		
		while (true) {
			String msg = in.readLine();
			log.debug(msg);
			out.println("Server received " + msg);
			out.flush();
			if (msg.equals("bye")) {
				break;
			}
		}
		socket.close();
		server.close();
	}

}
