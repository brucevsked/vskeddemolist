package com.appservercommon.cache;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.appservercommon")
@Slf4j
public class RedisTest {
	
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
	@Test
    public void test() throws Exception{
		String key="test";
		redisTemplate.opsForValue().set(key, "1002");
		redisTemplate.expire(key, 60*10, TimeUnit.SECONDS);//设置过期时间
    	log.debug("|"+redisTemplate.opsForValue().get(key)+"|");
    	redisTemplate.delete(key);
    	log.debug("|"+redisTemplate.opsForValue().get("test")+"|");
    }

}
