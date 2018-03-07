package com.vsked.test;

import java.io.IOException;

import org.apache.log4j.Logger;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sun.misc.BASE64Encoder;

public class Tomcat8Pass {
	
	private static Logger log = Logger.getLogger(Tomcat8Pass.class);
	
	public static void main(String[] args) {
		BaseTest.initLog4j();
		String userName="admin";
		String passWord="admin";
		passWord=new BASE64Encoder().encode((userName+":"+passWord).getBytes());
		System.out.println(passWord);
		String url = "http://localhost:8080/manager/html";
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder()
		    .header("Authorization", "Basic "+passWord)
		    .url(url)
		    .build();
		Call call = okHttpClient.newCall(request);
		try {
		    Response response = call.execute();
		    String responseContent=response.body().string();
		    log.debug(responseContent);
		} catch (IOException e) {
		    log.error(e.getMessage());
		}

	}

}
