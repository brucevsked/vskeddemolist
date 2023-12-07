package com.vsked.auth.web;

import com.vsked.auth.application.SessionApplicationService;
import com.vsked.auth.web.VO.AccountLoginInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SessionController {

    private static final Logger log = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    SessionApplicationService sessionApplicationService;

    @ResponseBody
    @PostMapping("/session")
    public String createSession(AccountLoginInfoVO accountLoginInfoVO){
        //创建会话
        log.info("create session ok");
        log.info(accountLoginInfoVO.toString());
        return sessionApplicationService.createSession(accountLoginInfoVO);
    }

    @GetMapping("/session")
    public void getSession(){
        //读取会话
        log.info("get session ok");
    }

    @PutMapping("/session")
    public void updateSession(){
        //更新会话
        log.info("update session ok");
    }

    @DeleteMapping("/session")
    public void destorySession(){
        //删除会话
        log.info("delete session ok");
    }

}
