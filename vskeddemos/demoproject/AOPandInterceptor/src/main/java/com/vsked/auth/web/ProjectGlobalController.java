package com.vsked.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectGlobalController {

    private static final Logger log = LoggerFactory.getLogger(ProjectGlobalController.class);

    @RequestMapping("/")
    public void indexTemp(){
        log.debug("here is indexTemp");
    }

}
