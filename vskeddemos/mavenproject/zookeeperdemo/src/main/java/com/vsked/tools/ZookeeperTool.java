package com.vsked.tools;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class ZookeeperTool implements Watcher {
	
	/**
     * 超时时间
     */
   private static final int SESSION_TIME_OUT = 2000;
   private CountDownLatch countDownLatch = new CountDownLatch(1);

	@Override
	public void process(WatchedEvent event) {
		if (event.getState() == KeeperState.SyncConnected) {
 System.out.println("Watch received event");
 countDownLatch.countDown();
 }
		

		
	}
	
	

}
