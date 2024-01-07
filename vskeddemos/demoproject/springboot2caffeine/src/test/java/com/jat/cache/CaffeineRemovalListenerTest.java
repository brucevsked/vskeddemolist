package com.jat.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * 淘汰通知
 */
public class CaffeineRemovalListenerTest {

    private static final Logger log = LoggerFactory.getLogger(CaffeineRemovalListenerTest.class);

    @Test
    public void test() throws InterruptedException {
        LoadingCache<Integer, Integer> cache = Caffeine.newBuilder()
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .scheduler(Scheduler.systemScheduler())
                // 增加了淘汰监听
                .removalListener(((key, value, cause) -> {
                    log.debug("{}","淘汰通知，key：" + key + "，原因：" + cause);
                }))
                .build(new CacheLoader<Integer, Integer>() {
                    @Override
                    public @Nullable Integer load(@NonNull Integer key) throws Exception {
                        return key;
                    }
                });

        cache.put(1, 2);

        Thread.currentThread().sleep(2000);
    }
}
