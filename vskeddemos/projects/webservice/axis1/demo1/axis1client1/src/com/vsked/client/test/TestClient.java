package com.vsked.client.test;


import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class TestClient {

	public static void main(String[] args) {
		String webServiceUrl = "http://localhost:8080/axis1server1/HelloWorldService.jws";
		Service service = new Service();
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(webServiceUrl);
			/**
			 * 设置调用的方法和方法的命名空间
			 * 因为这里是手动发布到webroot目录下的，所以命名空间和请求地址一致
			 * 当然null也可以，因为本身它就没有设置命名空间，一般方法的命名空间是
			 * 包名倒写组成，如com.vsked.service,ns=http://service.vsked.com
			 */
			call.setOperationName(new QName(null, "sayHello"));
			String result = (String) call.invoke(new Object[] { "vsked", "myPass" });
	        System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
