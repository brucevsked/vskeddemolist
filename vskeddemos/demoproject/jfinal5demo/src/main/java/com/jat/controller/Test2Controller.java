package com.jat.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/test2")
public class Test2Controller extends Controller {

    public void index(){
        List<Record> tests= Db.find("select * from test2a");
        renderJson(tests);
    }

    public void flow1Api(){
        Map<String,String> m=new HashMap<>();
        m.put("add","url1");
        m.put("name","title");
        renderJson(m);
    }
}
