package com.vsked.tools;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ZookeeperToolTest {
	
	private static final Logger log = LoggerFactory.getLogger(ZookeeperToolTest.class);

	public static void main(String[] args) {
		try{
		String host="192.168.111.81:2181";
		int sessionTimeout=50000;
		String path="/";
		ZookeeperTool watcher=new ZookeeperTool();
		ZooKeeper zkClient=new ZooKeeper(host, sessionTimeout, watcher);
		List<String> nodeList=zkClient.getChildren(path, false);
		log.debug("list|"+nodeList+"|");
		String path1="/测试";
		String path1Data="测试数据1";
		zkClient.create(path1, path1Data.getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		byte[] myDataByte=zkClient.getData(path1, watcher, null);
		String mydata=new String(myDataByte,"utf-8");
		log.debug("mydata|"+mydata+"|");
		zkClient.close();
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}

	}

}
