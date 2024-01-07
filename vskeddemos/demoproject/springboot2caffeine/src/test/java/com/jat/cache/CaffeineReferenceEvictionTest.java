package com.jat.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * 基于引用淘汰
 */
public class CaffeineReferenceEvictionTest {

    private static final Logger log = LoggerFactory.getLogger(CaffeineReferenceEvictionTest.class);

    @Test
    public void testWeak() {
        Cache<Integer, Integer> cache = Caffeine.newBuilder()
                // 设置Key为弱引用，生命周期是下次gc的时候
                .weakKeys()
                // 设置value为弱引用，生命周期是下次gc的时候
                .weakValues()
                .build();
        cache.put(1, 2);
        log.debug("{}",cache.getIfPresent(1));

        // 强行调用一次GC
        System.gc();

        log.debug("{}",cache.getIfPresent(1));
    }

    @Test
    public void testSoft() {
        Cache<Integer, Integer> cache = Caffeine.newBuilder()
                // 设置value为软引用，生命周期是GC时并且堆内存不够时触发清除
                .softValues()
                .build();
        cache.put(1, 2);
        log.debug("{}",cache.getIfPresent(1));

        // 强行调用一次GC
        System.gc();

        log.debug("{}",cache.getIfPresent(1));
    }
}
