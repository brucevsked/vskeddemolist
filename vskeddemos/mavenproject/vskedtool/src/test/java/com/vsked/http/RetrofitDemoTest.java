package com.vsked.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RetrofitDemoTest {

    private static final Logger log = LoggerFactory.getLogger(RetrofitDemoTest.class);

   @Test
    public void get1(){
        try{
            String myUrl="http://www.baidu.com";
            String result=RetrofitDemoImpl.get1(myUrl);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void get2(){
        try{
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("rsv_bp", "1");
            parMap.put("wd", "vsked");
            parMap.put("ie", "utf-8");
            String myUrl="http://www.baidu.com/s";
            String result=RetrofitDemoImpl.get2(myUrl,parMap);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void post1(){
        try{
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("post参数1", "a1");
            parMap.put("postb", "参数值b1");
            parMap.put("postc", "c1");
            String myUrl="http://localhost:8080/retrofitdemo/proc/test1proc1.jsp";
            String result=RetrofitDemoImpl.post1(myUrl,parMap);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void post2(){
        try{
            String myContent="{\"测试key\":\"valkue小二上菜\",\"来啊key\":\"来了\",\"去吧key\":\"听说valkue\"}";
            String myUrl="http://localhost:8080/retrofitdemo/proc/test1proc1.jsp";
            String result=RetrofitDemoImpl.post2(myUrl,myContent);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void post3(){
        try{
            //传文件时需要的参数
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("test1", "中文测试");
            parMap.put("b", "b1");
            parMap.put("c", "c1");

            //文件列表
            List<String> filePathList=new LinkedList<String>();
            filePathList.add("e:/1.jpg");
            filePathList.add("e:/2.jpg");
            filePathList.add("e:/3.jpg");
            filePathList.add("e:/ocr_id_02.jpg");
            String myUrl="http://localhost:8080/retrofitdemo/proc/test1proc1.jsp";
            String result=RetrofitDemoImpl.post3(myUrl,parMap,filePathList);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }


    @Test
    public void postSMS(){
        try{
            Map<String, Object> parMap=new HashMap<String, Object>();
            parMap.put("SpCode", "266021");
            parMap.put("dz_rx", "666");
            parMap.put("Password", "708e4a872bebf9e0eb6831ad12130462");
            parMap.put("MessageContent", "您有一条标题为完美发送的待处理热线工单，请及时登录德州市12345政务服务便民热线系统进行办理。");
            parMap.put("UserNumber", "13280009366");
            parMap.put("SerialNumber", "1000202204090001");
            String myUrl="https://api.ums86.com:9600/sms/Api/Send.do";
            String result=RetrofitDemoImpl.post1Ex(myUrl,parMap);
            log.debug("|"+result+"|");
        }catch(Exception e){
            log.error(e.getMessage(),e);
        }
    }

}
