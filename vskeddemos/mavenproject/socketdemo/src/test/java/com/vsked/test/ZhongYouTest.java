package com.vsked.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsked.common.SocketTool;
import com.vsked.common.StringTool;


public class ZhongYouTest {
	
	private static final Logger log = LoggerFactory.getLogger(ZhongYouTest.class);
	
	/**
	 *  查询帐户余额
	 * @throws Exception
	 */
//	@Test
	public void getAccountBalance() throws Exception{
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
	
	/**
	 * 充值测试
	 * @throws Exception
	 */
	@Test
	public void agentCashPayment() throws Exception{
		String host = "103.249.55.151";
		int port = 43001;
		int timeOut = 9000;
		
		String busiCode="OI_AgentCashPayment";
		String phoneNum="17056690992";
		
		String reqStr="";
		reqStr+="{";
		reqStr+=""+StringTool.getJsonKey("Request")+":";
		    reqStr+="{";
		    reqStr+=""+StringTool.getJsonKey("BusiParams")+":";
		        reqStr+="{";
		        reqStr+=""+StringTool.getJsonKey("AgentAcctId")+":"+StringTool.getJsonKey("10188")+",";
		        reqStr+=""+StringTool.getJsonKey("AgentNode")+":"+StringTool.getJsonKey("")+",";
		        reqStr+=""+StringTool.getJsonKey("ServiceNum")+":"+StringTool.getJsonKey(phoneNum)+",";
		        reqStr+=""+StringTool.getJsonKey("IsCheckPWD")+":"+StringTool.getJsonKey("0")+",";
		        reqStr+=""+StringTool.getJsonKey("AgentPWD")+":"+StringTool.getJsonKey("")+",";
		        reqStr+=""+StringTool.getJsonKey("AuditDate")+":"+StringTool.getJsonKey("")+",";
		        reqStr+=""+StringTool.getJsonKey("Amount")+":"+"1000"+",";
		        reqStr+=""+StringTool.getJsonKey("OppDoneCode")+":"+StringTool.getJsonKey("15080503")+",";
		        reqStr+=""+StringTool.getJsonKey("Sign")+":"+StringTool.getJsonKey("0d98da3ea686d2ae2371f8ec38f36c49")+"";
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
