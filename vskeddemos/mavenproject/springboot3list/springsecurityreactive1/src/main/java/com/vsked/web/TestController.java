package com.vsked.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/t1")
    public String t1(){

        log.trace("---------------1");
        log.info("---------------2");
        log.debug("---------------3");
        log.warn("---------------4");
        log.error("---------------5");

        return "{" +
                "\"code\":\"" + -1 + "\"," +
                "\"msg\":\"测试全局异常\"," +
                "\"data\":\"\"" +
                "}";
    }
}
