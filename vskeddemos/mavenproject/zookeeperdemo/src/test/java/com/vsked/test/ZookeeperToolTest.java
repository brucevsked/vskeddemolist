package com.vsked.test;

import com.vsked.tools.ZookeeperTool;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.nio.charset.StandardCharsets;


public class ZookeeperToolTest {

    private static final String zkHost="10.0.193.11:2181";
    private static final int sessionTimeout=500000;

    private static final Logger log = LoggerFactory.getLogger(ZookeeperToolTest.class);

    @Test
    public void create() throws Exception {
        ZookeeperTool watcher = new ZookeeperTool();
        ZooKeeper zkClient = new ZooKeeper(zkHost, sessionTimeout, watcher);
        String path1 = "/test";
        String path1Data = "test1 data is here";
        boolean isExist=isExistNode(zkClient,path1);
        log.info("{}",isExist);

        if(isExist){
            log.info("节点信息已经存在！");
            Stat stat=zkClient.exists(path1,true);
            log.info("{}",stat);
            zkClient.close();
        }else{
            log.info("没有这个节点，开始创建！");
            zkClient.create(path1, path1Data.getBytes(StandardCharsets.UTF_8), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            byte[] myDataByte = zkClient.getData(path1, watcher, null);
            String myData = new String(myDataByte, StandardCharsets.UTF_8);
            log.debug("节点创建成功:{}",myData);
            Stat stat=zkClient.exists(path1,true);
            log.info("节点状态：{}",stat);
            zkClient.close();
        }

    }

    @Test
    public void get()throws Exception {
        ZookeeperTool watcher = new ZookeeperTool();
        ZooKeeper zkClient = new ZooKeeper(zkHost, sessionTimeout, watcher);
        String path1 = "/test";
        Stat stat=zkClient.exists(path1,watcher);
        log.info("节点状态版本{}",stat.getVersion());
        zkClient.close();
    }

    @Test
    public void delete() throws Exception {
        ZookeeperTool watcher = new ZookeeperTool();
        ZooKeeper zkClient = new ZooKeeper(zkHost, sessionTimeout, watcher);
        String path1 = "/test";
        Stat stat=zkClient.exists(path1,watcher);
        int version=stat.getVersion();
        zkClient.delete(path1,version);
        zkClient.close();
    }

    public boolean isExistNode(ZooKeeper zk,String nodePath)throws Exception {
        Stat stat=zk.exists(nodePath,true);
        return stat!=null;
    }

}
