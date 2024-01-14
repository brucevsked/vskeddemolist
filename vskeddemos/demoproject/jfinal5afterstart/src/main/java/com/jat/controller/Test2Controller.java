package com.jat.controller;

import com.jat.service.MyService;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;


@Path("/test")
public class Test2Controller extends Controller {
    String version="this is test cluster1.0 server05";

    /**
     * 注入第二步，使用注解注入类
     */
    @Inject
    MyService myService;

    public void index(){
        renderHtml(version);
    }

    public void ver(){
        renderHtml(version);
    }

    public void t1(){
        //第三步，调用注入类的相关方法
        myService.createUser();
        renderHtml("test1 ok");
    }
}
