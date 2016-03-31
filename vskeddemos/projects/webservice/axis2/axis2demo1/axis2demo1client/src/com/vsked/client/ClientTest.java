package com.vsked.client;


import com.vsked.server.HelloWorldStub;

public class ClientTest {
	public static void main(String[] args) throws Exception {
		HelloWorldStub myStub=new HelloWorldStub();
		HelloWorldStub.SayHello sayHelloMethod=new HelloWorldStub.SayHello();
		sayHelloMethod.setMyName("test world!");
		HelloWorldStub.SayHelloResponse sayHelloResponse=myStub.sayHello(sayHelloMethod);
		String result=sayHelloResponse.get_return();
		System.out.println(result);
		
	}

}
