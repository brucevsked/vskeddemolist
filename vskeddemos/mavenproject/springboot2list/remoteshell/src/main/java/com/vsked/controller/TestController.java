package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vsked.service.RemoteShellService;

@Controller
public class TestController {
	
	@Autowired
	RemoteShellService remoteShellService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "helloinfo";
    }
    
    @RequestMapping("/rs1")
    @ResponseBody
    public String rs1(){
        return "rs1";
    }
    
    @RequestMapping("/cmd")
    @ResponseBody
    public String cmd(HttpServletRequest req){
        return remoteShellService.exec(req);
    }
    
    @RequestMapping("/centos")
    @ResponseBody
    public String centos(HttpServletRequest req){
        return remoteShellService.execCentos(req);
    }
}
