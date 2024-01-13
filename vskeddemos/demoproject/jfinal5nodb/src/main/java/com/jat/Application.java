package com.jat;

import com.jfinal.server.undertow.UndertowServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		log.info("start app");
		UndertowServer.start(DbConfig.class, 80, true);
	}

}
