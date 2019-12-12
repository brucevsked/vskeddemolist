package com.vsked.socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class SocketServerRunner implements CommandLineRunner {

	@Value("${socketconfig.port}")
	String port;
	
	@Override
	public void run(String... args) throws Exception {
		new Thread(new SocketServer(port)).start();
		System.out.println("===============================start"+port);
		
	}

}
