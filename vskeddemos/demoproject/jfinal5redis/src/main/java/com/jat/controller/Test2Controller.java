package com.jat.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.redis.Redis;

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

    public void redis1Api(){
        Redis.use("ktvdata").set("ktv1:room1:user1","mynameisvsked");
        Redis.use("ktvdata").set("ktv1:room1:user2","hack");
        Redis.use("ktvdata").set("ktv1:room1:user3","girltest");
        Map<String,String> m=new HashMap<>();


        Redis.use("ktvdata").setex("ktv1:room1:user4",20,"20秒后过期");

        String user1=Redis.use("ktvdata").get("ktv1:room1:user1");
        String user2=Redis.use("ktvdata").get("ktv1:room1:user2");
        String user3=Redis.use("ktvdata").get("ktv1:room1:user3");
        m.put("user1",user1);
        m.put("user2",user2);
        m.put("user3",user3);
        renderJson(m);
    }
}
