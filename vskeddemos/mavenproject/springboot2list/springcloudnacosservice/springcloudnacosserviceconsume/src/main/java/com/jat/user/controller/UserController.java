package com.jat.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jat.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    ProjectConfig projectConfig;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;


    @GetMapping("/echo")
    public String index(String id){
//        //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
//        ServiceInstance serviceInstance = loadBalancerClient.choose("myprovide1");
//        String url = String.format("http://%s:%s/user1?id=%s",serviceInstance.getHost(),serviceInstance.getPort(),id);
//        System.out.println("request url:"+url);
//        return restTemplate.getForObject(url,String.class);

        //根据服务名获取 服务内的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("myprovide1");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+":"+instance.getPort());
        }
        if(instances.size() > 0){
            int cur=new Random().nextInt(instances.size());
            System.out.println("随机取一个服务-----------------"+cur);
            String host = instances.get(cur).getHost();
            URI uri = instances.get(cur).getUri();
            int port = instances.get(cur).getPort();
            System.out.println("Host: " + host);
            System.out.println("URI: " + uri);
            System.out.println("port: " + port);
            String instanceId = instances.get(cur).getServiceId();
            System.out.println("instanceId : " + instanceId);
            return restTemplate.getForObject(uri + "/" + "user1?id="+id,String.class);
        }
        return "";
    }
}
