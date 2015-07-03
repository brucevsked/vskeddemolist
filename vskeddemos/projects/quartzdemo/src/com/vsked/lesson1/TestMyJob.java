package com.vsked.lesson1;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class TestMyJob {

	public static void main(String[] args) throws Exception {
		
		int interval=3;
		int repeatCount=5;
		
		String jobName="job1";
		String groupName="group1";
		String triggerName="trigger1";
		
		JobDetail jd=JobBuilder.newJob(MyJob.class).withIdentity(jobName, groupName).build();
		
		Trigger t=TriggerBuilder.newTrigger().withIdentity(triggerName, groupName)
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(interval)
						.withRepeatCount(repeatCount)).build();
		
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler s = sf.getScheduler();
		
		s.scheduleJob(jd,t);
		s.start();
	}

}
