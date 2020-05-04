package com.vsked.auth.web;

import com.vsked.auth.web.model.LoginInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @PostMapping
    @ResponseBody
    public String test1(@ModelAttribute LoginInfoVO loginInfo){
        log.debug(loginInfo.toString());
        return "testok1";
    }

    @GetMapping("/{ida}")
    @ResponseBody
    public String test1(@PathVariable("ida") String id, @Param("username") String username){
        log.debug("path|"+id+"|param|"+username);
        return id+"testok2"+username;
    }

    @PostMapping(consumes="application/json",value="/t3")
    @ResponseBody
    public String test3(@RequestBody LoginInfoVO loginInfo){
        log.debug(loginInfo.toString());
        return "testok3";
    }

}
