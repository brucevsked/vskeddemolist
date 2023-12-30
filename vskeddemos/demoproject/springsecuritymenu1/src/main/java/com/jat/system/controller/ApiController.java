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

    @PostMapping("/system/menu")
    public String system_menu(){
        return new JsonResult("200","您访问/system/menu成功了")+"";
    }
    @PostMapping("/system/role")
    public String system_role(){
        return new JsonResult("200","您访问/system/role成功了")+"";
    }
    @PostMapping("/system/user")
    public String system_user(){
        return new JsonResult("200","您访问/system/user成功了")+"";
    }

    @PostMapping("/system/user/addButton")
    public String system_userAdd(){
        return new JsonResult("200","您访问/system/user/addButton成功了")+"";
    }
    @PostMapping("/system/menu/addMenu")
    public String system_menuAdd(){
        return new JsonResult("200","您访问/system/menu/addMenu成功了")+"";
    }
}
