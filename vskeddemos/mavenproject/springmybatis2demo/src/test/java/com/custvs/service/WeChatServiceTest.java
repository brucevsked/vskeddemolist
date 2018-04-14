package com.custvs.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeChatServiceTest {
	
	private static final Logger log=LoggerFactory.getLogger(WeChatServiceTest.class);
	
	WeChatService wechatService=new WeChatService();
	
	@Test
	public void getAccessToken() throws Exception{
		String s=wechatService.getAccessToken();
		log.debug(s);
	}

}
