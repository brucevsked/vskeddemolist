package com.vsked.auth.web;

import com.vsked.auth.application.service.SessionApplicationService;
import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("/session")
    public String createSession(HttpServletRequest request) throws Exception {
        //创建会话
        log.info("create session ok in controller");
        return sessionApplicationService.createSession(request);
    }

}
