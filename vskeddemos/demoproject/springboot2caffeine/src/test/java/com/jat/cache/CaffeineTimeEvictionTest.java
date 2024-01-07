package com.jat.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import com.github.benmanes.caffeine.cache.Scheduler;
import org.checkerframework.checker.index.qual.NonNegative;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * 基于时间淘汰
 */
public class CaffeineTimeEvictionTest {

    private static final Logger log = LoggerFactory.getLogger(CaffeineTimeEvictionTest.class);

    /**
     * 访问后到期
     *
     * @throws InterruptedException
     */
    @Test
    public void testEvictionAfterProcess() throws InterruptedException {
        // 设置访问5秒后数据到期
        Cache<Integer, Integer> cache = Caffeine.newBuilder()
                .expireAfterAccess(5, TimeUnit.SECONDS).scheduler(Scheduler.systemScheduler())
                .build();
        cache.put(1, 2);
        log.debug("{}",cache.getIfPresent(1));

        Thread.sleep(6000);

        log.debug("{}",cache.getIfPresent(1));
    }

    /**
     * 写入后到期
     *
     * @throws InterruptedException
     */
    @Test
    public void testEvictionAfterWrite() throws InterruptedException {
        // 设置写入5秒后数据到期
        Cache<Integer, Integer> cache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS).scheduler(Scheduler.systemScheduler())
                .build();
        cache.put(1, 2);
        log.debug("{}",cache.getIfPresent(1));

        Thread.sleep(6000);

        log.debug("{}",cache.getIfPresent(1));
    }

    /**
     * 自定义过期时间
     *
     * @throws InterruptedException
     */
    @Test
    public void testEvictionAfter() throws InterruptedException {
        Cache<Integer, Integer> cache = Caffeine.newBuilder()
                .expireAfter(new Expiry<Integer, Integer>() {
                    // 创建1秒后过期，可以看到这里必须要用纳秒
                    @Override
                    public long expireAfterCreate(@NonNull Integer key, @NonNull Integer value, long currentTime) {
                        return TimeUnit.SECONDS.toNanos(1);
                    }

                    // 更新2秒后过期，可以看到这里必须要用纳秒
                    @Override
                    public long expireAfterUpdate(@NonNull Integer key, @NonNull Integer value, long currentTime, @NonNegative long currentDuration) {
                        return TimeUnit.SECONDS.toNanos(2);
                    }

                    // 读3秒后过期，可以看到这里必须要用纳秒
                    @Override
                    public long expireAfterRead(@NonNull Integer key, @NonNull Integer value, long currentTime, @NonNegative long currentDuration) {
                        return TimeUnit.SECONDS.toNanos(3);
                    }
                }).scheduler(Scheduler.systemScheduler())
                .build();

        cache.put(1, 2);

        log.debug("{}",cache.getIfPresent(1));

        Thread.sleep(6000);

        log.debug("{}",cache.getIfPresent(1));
    }
}
