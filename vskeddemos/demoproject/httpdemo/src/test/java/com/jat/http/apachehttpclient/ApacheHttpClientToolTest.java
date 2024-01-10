package com.jat.http.apachehttpclient;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApacheHttpClientToolTest {
	
	private static final Logger log = LoggerFactory.getLogger(ApacheHttpClientToolTest.class);
	
	@Test
	public void testGet1() {
		try {
			String getUrl = "http://127.0.0.1:8181/testurl";
			ApacheHttpClientTool httpTool=new ApacheHttpClientTool();
			String result = "";
			result = httpTool.get(getUrl);
			log.debug(result);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Test
	public void testGet2() {
		try {
			String getUrl = "http://127.0.0.1:8181/testurl";
			ApacheHttpClientTool httpTool=new ApacheHttpClientTool();
			String result = "";
	    	Map<String, String> requestParamterMap=new HashMap<String, String>();
	    	requestParamterMap.put("wd", "vsked");
	    	requestParamterMap.put("param2", "666");
			result = httpTool.get(getUrl,requestParamterMap);
			log.debug(result);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Test
	public void testPost1() {
		try {
			String postUrl = "http://127.0.0.1:8181/testurl";
			ApacheHttpClientTool httpTool=new ApacheHttpClientTool();
			String result = "";
			result = httpTool.post(postUrl);
			log.debug(result);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Test
	public void testPost2() {
		try {
			String postUrl = "http://127.0.0.1:8181/testurl";
			ApacheHttpClientTool httpTool=new ApacheHttpClientTool();
			String result = "";
	    	Map<String, String> requestParamterMap=new HashMap<String, String>();
	    	requestParamterMap.put("wd", "vsked");
	    	requestParamterMap.put("param2", "666");
	    	result=httpTool.post(postUrl,requestParamterMap);
			log.debug(result);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@Test
	public void testPost3() {
		try {
			String postUrl = "http://127.0.0.1:8181/testurl";
			ApacheHttpClientTool httpTool=new ApacheHttpClientTool();
	    	String result="";
	    	String testJson="{\"accountname\":\"admin\",\"password\":\"123456\"}";
	    	result=httpTool.post(postUrl,testJson);
			log.debug(result);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
