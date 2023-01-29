package com.vsked.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.vsked.test.BaseTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisTemplateTest extends BaseTest{
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void t1(){
		try{
		redisTemplate.opsForValue().set("name1", "vsked");
		redisTemplate.opsForValue().set("name2", "张三");
		String name2=(String) redisTemplate.opsForValue().get("name2");
		log.debug("|"+name2+"|");
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}

	@Test
	public void t2(){
		try{
			redisTemplate.opsForValue().set("name1", "vsked");
			redisTemplate.opsForValue().set("name2", "张三");
			String name2=(String) redisTemplate.opsForValue().get("name2");
			log.debug("|"+name2+"|");
		}catch(Exception e){
			log.error(e.getMessage(),e);
		}
	}

}
