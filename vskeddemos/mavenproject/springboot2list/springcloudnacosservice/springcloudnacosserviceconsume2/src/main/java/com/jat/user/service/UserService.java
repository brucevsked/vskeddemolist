package com.jat.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("myprovide1")
public interface UserService {

    @GetMapping("/user1")
    String index(@RequestParam("id") String id); //其实调的是服务提供者那儿的index,注意这里参数要加注解接收
}
