package com.vsked.test;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestDemo6 {

	public static void main(String[] args) {
		String getPrameter = "";
		getPrameter += "?";
		getPrameter += "userName=admin";
		getPrameter += "&password=admin";

		String myUrl = "http://localhost:8080/hyfd/LoginController/loginCheck.html"
				+ getPrameter;
		// 核心应用类
		HttpClient httpClient = HttpClients.createDefault();
		// HTTP请求
		HttpUriRequest request = new HttpPost(myUrl);
		// 打印请求信息
		System.out.println(request.getRequestLine());
		try {
			// 发送请求，返回响应
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			// 打印响应信息
			System.out.println(response.getStatusLine());
			System.out.println(EntityUtils.toString(entity));
			

			myUrl = "http://localhost:8080/hyfd/MobileInfoController/toList.html?pageSize=10";
			request = new HttpPost(myUrl);
			// 打印请求信息
			System.out.println(request.getRequestLine());

			request.setHeader("Cookie", getCookie(httpClient));
			
			response = httpClient.execute(request);
			entity = response.getEntity();
			// 打印响应信息
			System.out.println(response.getStatusLine());
			System.out.println(EntityUtils.toString(entity));

		} catch (Exception e) {
			// 协议错误
			e.printStackTrace();
		} 

	}
	
	public static String getCookie(HttpClient hc){
		StringBuilder sb=new StringBuilder();
		//TODO fixed here
		List<Cookie> cookies=((AbstractHttpClient)hc).getCookieStore().getCookies();
		for(Cookie cookie:cookies){
			sb.append(cookie.getName()+""+cookie.getValue()+";");
		}
		return sb.toString();
	}

}
