package com.vsked.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTask implements Runnable{

	public Long IntervalTime=2000L;
	
	private SimpleDateFormat mySdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(IntervalTime);
				System.out.println("NNNNNNNTTTTTT------||||"+mySdf.format(new Date()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
