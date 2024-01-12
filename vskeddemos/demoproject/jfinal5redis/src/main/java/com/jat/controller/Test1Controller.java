package com.jat.controller;

import com.jat.model.Test1Jat;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

@Path("/test")
public class Test1Controller extends Controller {
    public Test1Jat test1JatDao=new Test1Jat().dao();

    public void index(){
        List<Record> tests= Db.find("select * from test1_jat");
        renderJson(tests);
    }
}
