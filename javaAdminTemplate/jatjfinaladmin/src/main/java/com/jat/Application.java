package com.jat;

import com.jat.config.DbConfig;
import com.jfinal.server.undertow.UndertowServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private static int serverPort=80; //服务启动后访问端口号

	public static void main(String[] args) {
		log.info("----------start app----------");
		UndertowServer.start(DbConfig.class, serverPort, true);
	}
}
