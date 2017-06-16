package com.vsked.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.Logger;

/**
 * 作为测试的WebService实现类
 * 
 */
@WebService(endpointInterface = "com.vsked.service.SayHiService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SayHiServiceImp implements SayHiService {
	
	private static final Logger log = Logger.getLogger(SayHiServiceImp.class);

    public void SayHiDefault() {
        log.debug("Hi, vsked!");
    }

    public void SayHi(String name) {
    	log.debug("Hi, " + name + "!");
    }

    public int CheckTime(Date clientTime) {
        // 精确到秒
        String dateServer = new java.sql.Date(System.currentTimeMillis())
                .toString()
                + " "
                + new java.sql.Time(System.currentTimeMillis());
        String dateClient = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(clientTime);
        return dateServer.equals(dateClient) ? 1 : 0;
    }

}
