package com.vsked.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsked.common.SocketTool;
import com.vsked.common.StringTool;

public class SocketToolTest {
	
	private static final Logger log = LoggerFactory.getLogger(SocketToolTest.class);
	
	@Test
	public void socketSendJson() throws Exception{
		String host = "103.249.55.151";
		int port = 43001;
		int timeOut = 9000;
		 
        String busiCode="OI_GetAccountBalance";
        String phoneNum="17056690992";
			
		String reqStr="";
			reqStr+="{";
			reqStr+=""+StringTool.getJsonKey("Request")+":";
			    reqStr+="{";
			    reqStr+=""+StringTool.getJsonKey("BusiParams")+":";
			        reqStr+="{";
			        reqStr+=""+StringTool.getJsonKey("ServiceNum")+":"+StringTool.getJsonKey(phoneNum)+"";
			        reqStr+="}";
			        reqStr+=",";
			        reqStr+=""+StringTool.getJsonKey("BusiCode")+":"+StringTool.getJsonKey(busiCode);
			    reqStr+="},";
			reqStr+=""+StringTool.getJsonKey("PubInfo")+":";
			reqStr+="{";
			
			reqStr+=""+StringTool.getJsonKey("InterfaceId")+":"+StringTool.getJsonKey(busiCode)+",";
			reqStr+=""+StringTool.getJsonKey("TransactionId")+":"+StringTool.getJsonKey("fda20180120144842569298")+",";
			reqStr+=""+StringTool.getJsonKey("InterfaceType")+":"+StringTool.getJsonKey("32")+",";
			reqStr+=""+StringTool.getJsonKey("OpId")+":"+StringTool.getJsonKey("1000004015")+",";
			reqStr+=""+StringTool.getJsonKey("CountyCode")+":"+StringTool.getJsonKey("0400")+",";
			reqStr+=""+StringTool.getJsonKey("OrgId")+":"+StringTool.getJsonKey("100017215")+",";
			reqStr+=""+StringTool.getJsonKey("ClientIP")+":"+StringTool.getJsonKey("112.230.203.114")+",";
			reqStr+=""+StringTool.getJsonKey("TransactionTime")+":"+StringTool.getJsonKey("20180420150547")+",";
			reqStr+=""+StringTool.getJsonKey("RegionCode")+":"+StringTool.getJsonKey("400")+"";
			
			reqStr+="}";
			reqStr+="}";
			
		log.debug(reqStr);
		
        SocketTool socket=new SocketTool(host, port, timeOut);
        String retMsg = socket.sendJson(reqStr);
        log.debug(retMsg);
		
	}

}
