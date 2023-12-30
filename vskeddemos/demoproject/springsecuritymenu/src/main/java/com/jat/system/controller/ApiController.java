package com.jat.system.controller;

import com.jat.system.model.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @PostMapping("/system")
    public String system(){
        return new JsonResult("200","您访问/system成功了")+"";
    }

    @PostMapping("/system/menuList")
    public String menu(){
        return new JsonResult("200","您访问/system/menuList成功了")+"";
    }

    @PostMapping("/system/roleList")
    public String role(){
        return new JsonResult("200","您访问/system/roleList成功了")+"";
    }

    @PostMapping("/system/userList")
    public String user(){
        return new JsonResult("200","您访问/system/userList成功了")+"";
    }
}
