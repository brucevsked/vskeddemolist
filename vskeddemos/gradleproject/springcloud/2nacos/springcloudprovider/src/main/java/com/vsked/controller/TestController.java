package com.vsked.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/service1/{username}")
    public String service1(@PathVariable String username){
        return "hello service1"+username;
    }

}
