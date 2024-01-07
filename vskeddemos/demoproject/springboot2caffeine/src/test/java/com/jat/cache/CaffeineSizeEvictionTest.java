package com.jat.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 基于大小淘汰
 */
public class CaffeineSizeEvictionTest {

    private static final Logger log = LoggerFactory.getLogger(CaffeineSizeEvictionTest.class);

    @Test
    public  void test() throws InterruptedException {
        // 初始化缓存，缓存最大个数为1
        Cache<Integer, Integer> cache = Caffeine.newBuilder()
                .maximumSize(1)
                .build();

        cache.put(1, 1);
        // 打印缓存个数，结果为1
        log.debug("{}",cache.estimatedSize());

        cache.put(2, 2);
        // 稍微休眠一秒
        Thread.sleep(1000);
        // 打印缓存个数，结果为1
        log.debug("{}",cache.estimatedSize());
    }
}
