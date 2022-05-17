package com.jat.user.controller;

import com.jat.config.Plan1;
import com.jat.config.Plan2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanController {

    @Autowired
    Plan1 myPlan1;
    @Autowired
    Plan2 myPlan2;
    @Autowired
    Environment myPlan3;


    @GetMapping("/p1")
    public String plan1(){
        return myPlan1.toString();
    }

    @GetMapping("/p2")
    public String plan2(){
        return myPlan2.toString();
    }

    @GetMapping("/p3")
    public String plan3(){
        Integer id=new Integer(myPlan3.getProperty("project.id"));
        String name=myPlan3.getProperty("project.name");
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + "\"" +
                "}";
    }
}
