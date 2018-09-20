package com.vsked.http;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestToolA1 {
	private static final Logger log=LoggerFactory.getLogger(TestToolA1.class);

	public static void main(String[] args) {
		try{
		Map<String, Object> parMap=new LinkedHashMap<String, Object>();
		String act="partnerticket";
		String mid="1001";
		String rnd="868";
		String psize="5";
		String pindex="1";
		String time="1536888929";
		String auth="6ec3d7a83b949e34375c70a0099a7f6e";
		
		String reqUrl="http://10.0.192.193:8080/";
		parMap.put("act", act);
		parMap.put("mid", mid);
		parMap.put("rnd", rnd);
		parMap.put("psize", psize);
		parMap.put("pindex", pindex);
		parMap.put("time", time);
		parMap.put("auth", auth);
		TestTool tt=new TestTool();
		String result=tt.t1(reqUrl, parMap);
		log.debug(result);
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}

	}

}
