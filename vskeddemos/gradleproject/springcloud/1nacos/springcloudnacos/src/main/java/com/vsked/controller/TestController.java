package com.vsked.controller;

import com.vsked.config.MyConfig1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${system.myconfig.databaseusername}")
    private String databaseusername;
    @Value("${system.myconfig.databaseuserpass}")
    private String databaseuserpass;
    @Value("${system.myconfig.databasecount}")
    private Integer databasecount;

    @RequestMapping("/myconfig1")
    public String getMyconfig1(){
        return databaseusername+databaseuserpass+databasecount;
    }

}
