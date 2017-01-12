package com.vsked.test;

public class UserService {
	
	public static String getName(){
		String userName="mynameis vsked";
		System.out.println(userName);
		return userName;
	}
	
	public static void proc(){
		MyTask task1=new MyTask();
		Thread t1=new Thread(task1);
		t1.start();
	}

}
