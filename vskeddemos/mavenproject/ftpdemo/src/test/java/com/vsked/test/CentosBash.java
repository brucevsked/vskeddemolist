package com.vsked.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsked.common.BashTool;

public class CentosBash {

	private static final Logger log = LoggerFactory.getLogger(CentosBash.class);

	@Test
	public void exeCommand() {
		log.info("start link");
		try {
			String command = "ls -l /opt/";
			String host = "192.168.111.77";
			String userName = "root";
			String userPass = "root";
			int port = 22;
			BashTool bt=new BashTool(host, userName, userPass, port);
			bt.connect();
			String result=bt.exeBash(command);
			log.info("|"+result+"|");
			bt.disconnect();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
