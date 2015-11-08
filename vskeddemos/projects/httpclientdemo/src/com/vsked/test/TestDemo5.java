package com.vsked.test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;

public class TestDemo5 {

	public static void main(String[] args) {
		int i =0;
		HttpClient httpClient = HttpClients.createDefault();
		HttpUriRequest request = null;
		request = new HttpGet("https://www.baidu.com/img/bd_logo1.png");
		try {
			// 执行getMethod
			HttpResponse response = httpClient.execute(request);
			System.out.println(request.getRequestLine());
			HttpEntity entity = response.getEntity();
			// 读取内容
			String picName = "e:/" + i + ".png";
			InputStream is = entity.getContent();
			OutputStream os = new FileOutputStream(picName);
			IOUtils.copy(is, os);
			IOUtils.closeQuietly(os);
			IOUtils.closeQuietly(is);
			System.out.println(i + "OK!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
