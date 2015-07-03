package com.vsked.scheduledexecutor;

import java.util.Date;

public class MyJobSc implements Runnable{
	private String jobName="defaultJob";
	private int jobCount=0;
	
	private boolean isRuning=true;
	
	public boolean isRuning() {
		return isRuning;
	}

	public void setRuning(boolean isRuning) {
		this.isRuning = isRuning;
	}

	public int getJobCount() {
		return jobCount;
	}

	public MyJobSc(String jobName) {
		super();
		this.jobName = jobName;
		jobCount=0;
	}

	@Override
	public void run() {
		while(isRuning){
		
		if(jobCount==4)isRuning=false;
		
		jobCount++;
		System.out.println(new Date()+ "this is my job:"+jobName+"|current count is:"+jobCount);
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}//end while
	}

}
