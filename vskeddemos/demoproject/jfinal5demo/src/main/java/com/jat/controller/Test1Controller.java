package com.jat.controller;

import com.jat.model1.Test1Jat;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/test")
public class Test1Controller extends Controller {

    private static final Logger log = LoggerFactory.getLogger(Test1Controller.class);

    public Test1Jat test1JatDao=new Test1Jat().dao();

    public void index(){
        List<Record> tests= Db.find("select * from test1_jat");
        renderJson(tests);
    }

    @Before(POST.class)
    public void mypost(){
        String id=getPara("id");
        String name=getPara("name");
        log.info("-------------------------------{}:{}",id,name);
        renderJson("{\"test\":666}");
    }

    public void config(){
        Prop prop= PropKit.use("db.txt");
        String jdbcUrl=prop.get("jdbcUrl");
        renderHtml(jdbcUrl);
    }

    public void jsonLetter(){
        Map<String,String> data=new HashMap<>();
        data.put("myName","11");
        data.put("chooseUser","8869");
        renderJson(data);
    }

    public void save2(){

        // 循环批量插入自增数据测试
        for(int i=0;i<20;i++){
            Test1Jat s1=new Test1Jat();
            s1.setId(null);
            s1.setName("myname"+i);
            s1.save();
        }
        renderHtml("批量保存成功啦啦啦");
    }

}
