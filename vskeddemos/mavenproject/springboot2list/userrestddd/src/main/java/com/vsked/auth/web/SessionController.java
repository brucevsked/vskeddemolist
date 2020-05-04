package com.vsked.auth.web;

import com.vsked.auth.application.LoginService;
import com.vsked.auth.web.model.LoginInfoVO;
import com.vsked.domain.shared.model.RespModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("/session")
@RestController
public class SessionController {

    private static final Logger log = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    LoginService loginService;

    @PostMapping
    @ResponseBody
    public RespModel login(@ModelAttribute LoginInfoVO loginInfo){
        log.debug(loginInfo.toString());
        return loginService.login(loginInfo);
    }

}
