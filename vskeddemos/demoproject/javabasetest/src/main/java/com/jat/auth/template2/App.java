package com.jat.auth.template2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public String hello(String string) {
		log.info("App start");
		log.info("App end");
		return string;
	}

}
