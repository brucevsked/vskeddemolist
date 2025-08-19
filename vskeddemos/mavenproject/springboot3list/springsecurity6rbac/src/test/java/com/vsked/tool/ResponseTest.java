package com.vsked.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResponseTest {

    private static final Logger log = LoggerFactory.getLogger(ResponseTest.class);

    @Test
    public void response1(){
        Response<?> r =new Response<>();
        log.info("{}",r);
        log.info("{}",r.getCode());
    }

    @Test
    public void responseJson(){
        Response<?> r =new Response<>(200,"success");
        log.info("{}",r);
        log.info("{}",r.getCode());
        log.info("{}",r.getMsg());
    }

    @Test
    public void response2(){
        Response<?> r =new Response<>(200,"success",1000);
        log.info("{}",r);
        log.info("{}",r.getCode());
        log.info("{}",r.getMsg());
        log.info("{}",r.getData());
    }

    @Test
    public void responseMap(){
        Map<String,String> data=new HashMap<>();
        data.put("userName","peter");
        data.put("role","admin");
        data.put("token","goodLuck");
        Response<Map<String,String>> r =new Response<>(200,"success",data);
        log.info("{}",r);
    }

    @Test
    public void response3(){
        List<String> dataList=new LinkedList<>();
        dataList.add("good1");
        dataList.add("good2");
        dataList.add("good3");
        Response<List<String>> r =new Response<>();
        r.setCode(500);
        r.setMsg("server error ");
        r.setData(dataList);
        log.info("{}",r);
    }


}
