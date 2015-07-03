package com.vsked.test;

import java.sql.Timestamp;

public class TestThread1 implements Runnable{

	public static void main(String[] args) {
		for(int i=0;i<2;i++){
		Thread t=new Thread(new TestThread1());
		t.start();
		}

	}

	@Override
	public void run() {
		while(true){
		System.out.println(new Timestamp(System.currentTimeMillis()));
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

}
