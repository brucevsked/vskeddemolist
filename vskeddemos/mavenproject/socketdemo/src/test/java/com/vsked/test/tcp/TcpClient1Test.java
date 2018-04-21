package com.vsked.test.tcp;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient1Test {
	
	private static final Logger log = LoggerFactory.getLogger(TcpClient1Test.class);
	
	@Test
	public void startServer() throws Exception{
		String host="localhost";
		int port=10015;
		Socket socket = new Socket(host, port);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String msg = reader.readLine();
			out.println(msg);
			out.flush();
			if (msg.equals("bye")) {
				break;
			}
			log.debug(in.readLine());
		}
		socket.close();
	}

}
