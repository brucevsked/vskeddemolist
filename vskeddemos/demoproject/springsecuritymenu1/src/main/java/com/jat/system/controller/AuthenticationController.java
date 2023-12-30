package com.jat.system.controller;

import com.jat.system.model.JsonResult;
import com.jat.system.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/authentication")
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @Transactional
    @PostMapping
    public String login(String name, String password){
        String token=authenticationService.authentication(name,password);
        return new JsonResult("200","登录成功！",token)+"";
    }


}
