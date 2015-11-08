package com.vsked.test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestDemo2 {

	public static void main(String[] args) throws Exception {
		// 核心应用类
		HttpClient httpClient = HttpClients.createDefault();
		List<NameValuePair> parameterList = new ArrayList<NameValuePair>();
		parameterList.add(new BasicNameValuePair("q", "httpclient"));
		parameterList.add(new BasicNameValuePair("btnG", "Google Search"));
		parameterList.add(new BasicNameValuePair("aq", "f"));
		parameterList.add(new BasicNameValuePair("oq", null));
		URI uri = URIUtils.createURI("http", "www.google.com", -1, "/search",URLEncodedUtils.format(parameterList, "UTF-8"), null);
		// HTTP请求
		HttpUriRequest request =  new HttpGet(uri);
		// 打印请求信息
		System.out.println(request.getRequestLine());
		// 发送请求，返回响应
		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		// 打印响应信息
		System.out.println(response.getStatusLine());
		System.out.println(EntityUtils.toString(entity));

	}

}
