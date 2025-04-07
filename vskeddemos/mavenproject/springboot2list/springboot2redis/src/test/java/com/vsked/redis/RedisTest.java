package com.vsked.redis;

import com.vsked.test.BaseTestWithoutTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RedisTest extends BaseTestWithoutTransactional {
    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Resource
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void saveString(){
        String redisKey="springBoot2Redis:module1:userNameF1";
        String redisValue="myNameIsBruce";
        redisTemplate.opsForValue().set(redisKey,redisValue);
    }

    @Test
    public void delString(){
        String redisKey="springBoot2Redis:module1:userNameF1";
        redisTemplate.delete(redisKey);
    }

    @Test
    public void save2String(){
        String redisKey="springBoot2Redis:module1:userName15";
        String redisValue="myNameIsBruce5s";
        redisTemplate.opsForValue().set(redisKey,redisValue,15, TimeUnit.SECONDS);
    }

    @Test
    public void saveList(){
        String redisKey="springBoot2Redis:module1:userList1";
        List<Map<String,Object>> testDataList=new LinkedList<>();
        for(int i=0;i<100000;i++){
            Map<String,Object> dataMap=new HashMap<>();
            dataMap.put("user"+i,"value"+i);
            testDataList.add(dataMap);
        }
        redisTemplate.opsForValue().set(redisKey,testDataList);
    }

    @Test
    public void getList(){
        String redisKey="springBoot2Redis:module1:userList1";
        List<Map<String,Object>> testDataList= (List<Map<String, Object>>) redisTemplate.opsForValue().get(redisKey);
        log.info("{}",testDataList);
    }




}
