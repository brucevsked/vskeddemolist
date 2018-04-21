package com.vsked.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsked.common.StringTool;

public class StringToolTest {
	
	private static final Logger log = LoggerFactory.getLogger(StringToolTest.class);
	
	@Test
	public void getJsonKey(){
		String s="";
		String r=StringTool.getJsonKey(s);
		log.debug(r);
	}

}
