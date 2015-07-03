package com.vsked.scheduledexecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class ScheduledExecutorTest {

	public static void main(String[] args) {
		Executor p = Executors.newFixedThreadPool(10);
		p.execute(new MyJobSc("job1"));

	}

}
