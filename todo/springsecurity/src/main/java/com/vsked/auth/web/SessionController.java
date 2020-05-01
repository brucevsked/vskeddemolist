package com.vsked.auth.web;

import com.vsked.auth.entity.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/session")
@RestController
public class SessionController {

    @PostMapping(consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    @ResponseBody
    public String login(@RequestBody User user, String error){
        System.out.println(error);
        return "good boy";
    }


}
