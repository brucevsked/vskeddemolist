package com.vsked.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class MybatisRedisCache implements Cache {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    static RedisTemplate<String, Object> redisTemplate;
    
    public static void setRedisTemplate(RedisTemplate<String, Object> c1){
    	redisTemplate=c1;
    }

    private String id;

    public MybatisRedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        //logger.info("Redis Cache id " + id);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        if (value != null) {
            // 向Redis中添加数据，有效时间是2天
            redisTemplate.opsForValue().set(key.toString(), value, 2, TimeUnit.DAYS);
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            if (key != null) {
                Object obj = redisTemplate.opsForValue().get(key.toString());
                return obj;
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        try {
            if (key != null) {
                redisTemplate.delete(key.toString());
            }
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
        }
        return null;
    }

    @Override
    public void clear() {
        //logger.debug("清空缓存");
        try {
            Set<String> keys = redisTemplate.keys("*:" + this.id + "*");
            if (!CollectionUtils.isEmpty(keys)) {
                redisTemplate.delete(keys);
            }
        } catch (Exception e) {
        	log.error(e.getMessage(),e);
        }
    }

    @Override
    public int getSize() {
        Long size = (Long) redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
        return size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
