package com.vsked.test;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.vsked.client.SayHiService;
import com.vsked.client.SayHiServiceImpService;

public class ClientTest extends BaseTest{
	
	private static final Logger log = Logger.getLogger(ClientTest.class);
	
	@Test
	public void testCallWebService(){
		try{
		 // 获取service
        SayHiService service = new SayHiServiceImpService().getSayHiServiceImpPort();
        
        // sayhi
        service.sayHiDefault();
        service.sayHi("lost wind 空空如也");
        
        // checktime
        // 这里主要说一下时间日期的xml传递，方法还略显复杂
        GregorianCalendar calender = new GregorianCalendar();
        calender.setTime(new Date(System.currentTimeMillis()));
        XMLGregorianCalendar xmldate = DatatypeFactory.newInstance().newXMLGregorianCalendar(calender);
        log.debug(service.checkTime(xmldate));
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
}
