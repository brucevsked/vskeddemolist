package com.vsked.controller;

import com.vsked.common.StringTool;
import com.vsked.common.SysConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class TestSendController {
    private static final Logger log = LoggerFactory.getLogger(TestSendController.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/testsend")
    public String send() throws Exception {
        log.trace("-----------------------1");
        Map<String,Object> clientDataMap=new HashMap<>();
        clientDataMap.put("code","0000");//0000 成功 0001 服务端无此主题 0002 服务端异常
        clientDataMap.put("from","server");//
        clientDataMap.put("to","alluser");//接收方server客户端发给服务端,alluser发给所有用户,client服务端发给客户端,user发给指定用户
        clientDataMap.put("type","3");//消息类型,1用户对用户2用户对服务器3服务器对用户4暂未使用
        clientDataMap.put("time","20220325113444565");//yyyyMMddHHmmssSSS
        Map<String,Object> data=new HashMap<>();
        data.put("dtype","3");//连接类型,1客户端推送服务端主题,2客户端取消服务端推送,3服务端推送给客户端对应主题数据,4心跳连接
        data.put("dvalue","myTopic1");//连接类型为1或2时主题 连接类型为4时固定值ping

        List<Map<String,Object>> ddataList=new LinkedList<>();
        Map<String,Object> data1=new HashMap<>();
        data1.put("myid","testId"+new Random().nextInt(100));
        data1.put("curtime","20220325113444565");
        data1.put("myData",new Random().nextInt(1000));

        ddataList.add(data1);
        data.put("ddata",ddataList);//连接类型为1或2时主题 连接类型为4时固定值ping

        clientDataMap.put("data",data);

        String msg= StringTool.mapToJson(clientDataMap);

        redisTemplate.convertAndSend(SysConstant.webSocketChannel,msg);
        log.trace("-----------------------2");
        return "";
    }

}
