package com.vsked.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRunJar {
	private static final Logger log = LoggerFactory.getLogger(TestRunJar.class);

	public static void main(String[] args) {
		log.info("here is run jar");
		
		for(String s:args) {
			log.info("|"+s);
		}
	}

}
