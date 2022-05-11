package com.jat.test.zookeeper;

import com.jat.config.ZkConfiguration;
import com.jat.test.BaseTestWithoutTransactional;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ZkTest extends BaseTestWithoutTransactional {

    private static final Logger log = LoggerFactory.getLogger(ZkTest.class);
    @Autowired
    private ZkConfiguration zk;

    // 测试连接
    @Test
    private void contextLoads() {
        CuratorFramework client= zk.curatorFramework();
        System.out.println(client.toString());
    }

    // 创建节点
    @Test
    private void createPath() throws Exception{
        CuratorFramework client= zk.curatorFramework();
        // 父节点不存在则创建
        String path = client.create().creatingParentsIfNeeded().forPath("/myJavaTest/p1" ,
                "中文节点内容测试".getBytes(StandardCharsets.UTF_8));
        log.info("{}",path);
        byte[] data = client.getData().forPath("/myJavaTest/p1");
        log.info("{}",new String(data));
    }

    // 赋值，修改数据
    @Test
    private void setData() throws Exception{
        CuratorFramework client = zk.curatorFramework();

        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/myJavaTest/p1");
        int version = stat.getVersion(); //当前节点的版本信息
        // 如果版本信息不一致，说明当前数据被修改过，则修改失败程序报错
        client.setData().withVersion(version).forPath("/myJavaTest/p1",
                "修改后的数据是这个".getBytes(StandardCharsets.UTF_8));
        byte[] data = client.getData().forPath("/myJavaTest/p1");
        log.info("{}",new String(data));
    }

    // 查询节点
    @Test
    private void getPath() throws Exception{
        CuratorFramework client= zk.curatorFramework();
        // 查内容
        byte[] data = client.getData().forPath("/myJavaTest/p1");
        log.info("{}",new String(data));

        // 查状态
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/myJavaTest/p1");
        log.info("{}",stat.getVersion());
    }

//    // 删除节点
    @Test
    private void deletePath() throws Exception{
        CuratorFramework client= zk.curatorFramework();
        client.delete().guaranteed().deletingChildrenIfNeeded().forPath("/myJavaTest/p1");
    }

    // 查询子节点
    @Test
    void getPaths() throws Exception{
        CuratorFramework client= zk.curatorFramework();
        List<String> paths = client.getChildren().forPath("/myJavaTest");
        for(String p : paths){
            log.info("{}",p);
        }
    }

}
