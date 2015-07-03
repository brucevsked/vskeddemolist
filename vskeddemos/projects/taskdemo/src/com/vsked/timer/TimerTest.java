package com.vsked.timer;

import java.util.Timer;

public class TimerTest {

	public static void main(String[] args) {
		//尽量不要用这种方案
		boolean flag=true;
		Timer t = new Timer(); 
		long delay1 = 1 * 1000;
		long interval = 3000; //间隔
		
		MyJobTi j=new MyJobTi("job1");

		// 从现在开始 1 秒钟之后，每隔 3秒钟执行一次 job1  
		t.schedule(j, delay1, interval);  
		
		while(flag){
			if(j.getJobCount()==5){
				j.cancel();
				t.cancel();
				flag=false;
			}
		}

	}

}
