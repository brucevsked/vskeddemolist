package com.jat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jat.controller.model.LoginAccount;
import com.jat.controller.model.UserView;
import com.jat.service.UserAccountService;
import com.jat.util.JsonUtil;
import com.jat.util.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserAccountController {

    private static final Logger log = LoggerFactory.getLogger(UserAccountController.class);

    @Autowired
    UserAccountService userAccountService;

    @PostMapping("/manager/user/login")
    public String login(@RequestBody LoginAccount loginAccount) throws JsonProcessingException {
        log.debug("{}",loginAccount);
        String token=userAccountService.login(loginAccount);
        Map<String,String> dataMap=new HashMap<>();
        dataMap.put("token",token);
        String dataJson= JsonUtil.objectToJson(dataMap);
        Response response=new Response();
        response.setCode(0);
        response.setMsg("登录成功！");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

    @PostMapping("/manager/user/logout")
    public String logout(HttpServletRequest req){
        Response response = new Response();
        userAccountService.logout(req);
        response.setCode(0);
        response.setMsg("注销成功！");
        return response+"";
    }


    @GetMapping("/manager/user/info")
    public String info(HttpServletRequest req) throws JsonProcessingException {
        UserView currentUser=userAccountService.getUserInfo(req);
        String dataJson= JsonUtil.objectToJson(currentUser);
        Response response=new Response();
        response.setCode(0);
        response.setMsg("获取用户信息成功！");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }


}
