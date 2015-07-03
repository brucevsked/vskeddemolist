package com.vsked.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class TestDemo1 {

	public static void main(String[] args) {
		// 核心应用类
		HttpClient httpClient = new DefaultHttpClient();
		// HTTP请求
		HttpUriRequest request = new HttpGet("http://www.baidu.com");
		// 打印请求信息
		System.out.println(request.getRequestLine());
		try {
			// 发送请求，返回响应
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity =response.getEntity();
			// 打印响应信息
			System.out.println(response.getStatusLine());
			System.out.println(EntityUtils.toString(entity));
		} catch (Exception e) {
			// 协议错误
			e.printStackTrace();
		}finally{
			httpClient.getConnectionManager().shutdown();
		}

	}

}
