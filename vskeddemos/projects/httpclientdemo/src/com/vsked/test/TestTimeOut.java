package com.vsked.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestTimeOut {

	public static void main(String[] args) throws Exception {
		/**
		 * setConnectTimeout：设置连接超时时间，单位毫秒。
           setConnectionRequestTimeout：设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
           setSocketTimeout：请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
		 */
		CloseableHttpClient httpclient = HttpClients.createDefault();  
		HttpGet httpGet = new HttpGet("http://www.baidu.com/");  
		RequestConfig requestConfig = RequestConfig.custom()  
		        .setConnectTimeout(5000).setConnectionRequestTimeout(1000)  
		        .setSocketTimeout(5000).build();  
		httpGet.setConfig(requestConfig);  
		CloseableHttpResponse response = httpclient.execute(httpGet);  
		System.out.println("得到的结果:" + response.getStatusLine());//得到请求结果  
		HttpEntity entity = response.getEntity();//得到请求回来的数据
		System.out.println(response.getStatusLine());
		System.out.println(EntityUtils.toString(entity));

	}
	
}
