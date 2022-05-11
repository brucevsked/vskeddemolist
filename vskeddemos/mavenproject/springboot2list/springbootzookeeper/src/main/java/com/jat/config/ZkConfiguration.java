package com.jat.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZkConfiguration {

    @Autowired
    private CuratorConf curatorConf;

    /**
     * 这里会自动调用一次start，请勿重复调用
     */
    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        return CuratorFrameworkFactory.newClient(
                curatorConf.getConnectString(),
                curatorConf.getSessionTimeoutMs(),
                curatorConf.getConnectionTimeoutMs(),
                new RetryNTimes(curatorConf.getRetryCount(), curatorConf.getElapsedTimeMs()));
    }

}
