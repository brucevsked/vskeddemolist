package com.vsked.redis;

import com.vsked.test.BaseTestWithoutTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RedisTest extends BaseTestWithoutTransactional {

    private static final Logger log = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Test
    public void printConnectionInfo() {
        var factory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();

        log.info("=================== Redis Connection Info ===================");
        log.info("Host: {}:{}", factory.getHostName(), factory.getPort());
        log.info("Database: {}", factory.getDatabase());
        log.info("Password: {}", factory.getPassword());
        log.info("Timeout: {}", factory.getTimeout());
        log.info("SSL: {}", factory.isUseSsl());
        log.info("Cluster: {}", factory.getClusterConfiguration());
        // 打印连接池信息
        // 获取 Lettuce 连接池配置
        try {
            var field = factory.getClass().getDeclaredField("clientConfiguration");
            field.setAccessible(true);
            var clientConfig = field.get(factory);

            log.info("=================== Lettuce Pool Info ===================");
            log.info("Client Configuration: {}", clientConfig);
        } catch (Exception e) {
            log.error("无法获取连接池配置信息: {}", e.getMessage());
        }
        log.info("===========================================================");
    }

    @Test
    public void saveString(){
        String redisKey="springBoot2Redis:module1:userNameF1";
        String redisValue="myNameIsBruce";
        redisTemplate.opsForValue().set(redisKey,redisValue);
        log.info("{}",redisTemplate.opsForValue().get(redisKey));
    }

    @Test
    public void saveStringWithTime(){
        String redisKey="springBoot4Redis:module1:userNameF1";
        String redisValue="myNameIsBruce";
        redisTemplate.opsForValue().set(redisKey,redisValue,10,TimeUnit.MINUTES);
        log.info("{}",redisTemplate.opsForValue().get(redisKey));
    }

    @Test
    public void delString(){
        String redisKey="springBoot2Redis:module1:userNameF1";
        redisTemplate.delete(redisKey);
        log.info("{}",redisTemplate.opsForValue().get(redisKey));
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
        for(int i=0;i<10;i++){
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
