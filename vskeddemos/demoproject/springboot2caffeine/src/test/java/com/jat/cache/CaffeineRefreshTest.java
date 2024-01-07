package com.jat.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * 刷新机制
 */
public class CaffeineRefreshTest {

    private static final Logger log = LoggerFactory.getLogger(CaffeineRefreshTest.class);
    private int index = 1;

    /**
     * 模拟从数据库中读取数据
     *
     * @return
     */
    private int getInDB() {
        // 这里为了体现数据重新被get，因而用了index++
        index++;
        return index;
    }

    @Test
    public void test() throws InterruptedException {
        // 设置写入后3秒后数据过期，2秒后如果有数据访问则刷新数据
        LoadingCache<Integer, Integer> cache = Caffeine.newBuilder()
                .refreshAfterWrite(2, TimeUnit.SECONDS)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build(new CacheLoader<Integer, Integer>() {
                    @Nullable
                    @Override
                    public Integer load(@NonNull Integer key) {
                        return getInDB();
                    }
                });
        cache.put(1, getInDB());

        // 休眠2.5秒，后取值
        Thread.sleep(2500);
        log.debug("{}",cache.getIfPresent(1));

        // 休眠1.5秒，后取值
        Thread.sleep(1500);
        log.debug("{}",cache.getIfPresent(1));
    }
}
