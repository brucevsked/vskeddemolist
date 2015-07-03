package com.vsked.timer;

import java.util.Date;
import java.util.TimerTask;

public class MyJobTi extends TimerTask {
	
	private String jobName="defaultJob";
	private int jobCount=0;
	
	public int getJobCount() {
		return jobCount;
	}

	public MyJobTi(String jobName) {
		super();
		this.jobName = jobName;
		jobCount=0;
	}

	@Override
	public void run() {
		jobCount++;
		System.out.println(new Date()+ "this is my job:"+jobName+"|current count is:"+jobCount);		
	}

}
