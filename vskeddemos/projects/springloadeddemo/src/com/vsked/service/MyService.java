package com.vsked.service;

import com.vsked.task.MyTask;

public class MyService {
	
	public static void proc(){
		MyTask task1=new MyTask();
		Thread t1=new Thread(task1);
		t1.start();
	}
	
	public static void proc1(){
		System.out.println("||||||lakjsdflasjdf11");
	}

}
