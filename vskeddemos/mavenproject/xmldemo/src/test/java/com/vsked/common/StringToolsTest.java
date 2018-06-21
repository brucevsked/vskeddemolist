package com.vsked.common;

import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringToolsTest {
	
	private static final Logger log=LoggerFactory.getLogger(StringToolsTest.class);
	
	@Test
	public void xmlToMap_dom4j(){
		TraceUtils.beginTrace();
		try{
			String xml="";
			xml+="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			xml+="<EPOSPROTOCOL>";
			xml+="<RSPCOD>000000</RSPCOD>";
			xml+="<RSPMSG>上传成功</RSPMSG>";
			xml+="<DATA>20180620-1800-c71f8760-1313-48bc-8697-2cf6866d9608</DATA>";
			xml+="</EPOSPROTOCOL>";
			log.debug("xml|"+xml+"|");
			Map<String, Object> resultMap=StringTools.xmlToMap_dom4j(xml);
			log.debug("resultMap|"+resultMap+"|");
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
		TraceUtils.endTrace();
	}

}
