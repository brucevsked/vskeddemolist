package com.vsked.test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.log4j.Logger;
import org.junit.Test;

public class MyOkHttpTest extends BaseTest{
	
	private static Logger log = Logger.getLogger(MyOkHttpTest.class);
	
//	@Test
	public void getTest1(){
		String url = "https://www.baidu.com/";
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder()
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
	
//	@Test
	public void postTest1(){
		String loginUrl="http://localhost:8080/simcustc1/login";
		String suName="admin";
		String suPass="000000";
		
		FormBody.Builder params=new FormBody.Builder();
		params.add("suName", suName);
		params.add("suPass", suPass);
		
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request=new Request.Builder()
        .url(loginUrl)
        .post(params.build())
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
