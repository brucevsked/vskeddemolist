package com.vsked.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer1/{username}")
    public String service1(@PathVariable String username){
        return restTemplate.getForObject("http://myprovider1/service1/" + username, String.class);
    }

}
