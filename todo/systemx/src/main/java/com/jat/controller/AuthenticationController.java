package com.jat.controller;

import com.jat.bo.JsonResponseResult;
import com.jat.service.AuthenticationService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class AuthenticationController {

    @Resource
    AuthenticationService authenticationService;

    @Transactional
    @PostMapping(value = "/w/authentication")
    public String create(String accountName, String accountPassword){
        return new JsonResponseResult("0000","用户登录成功！",authenticationService.login(accountName,accountPassword)) +"";
    }

//    @Transactional
//    @DeleteMapping("/w/user/deleteAuthentication")
//    public String delete(Long certificateId){
//        authenticationService.delete(certificateId);
//        return new JsonResult("0000","用户退出成功！")+"";
//    }

}
