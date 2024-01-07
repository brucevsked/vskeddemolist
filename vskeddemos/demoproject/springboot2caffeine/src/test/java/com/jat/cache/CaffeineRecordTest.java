package com.jat.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.testng.annotations.Test;

/**
 * 缓存记录
 */
public class CaffeineRecordTest {

    private static final Logger log = LoggerFactory.getLogger(CaffeineRecordTest.class);

    /**
     * 模拟从数据库中读取数据
     *
     * @param key
     * @return
     */
    private int getInDB(int key) {
        return key;
    }

    @Test
    public void test() {
        LoadingCache<Integer, Integer> cache = Caffeine.newBuilder()
                // 开启记录
                .recordStats()
                .build(new CacheLoader<Integer, Integer>() {
                    @Override
                    public @Nullable Integer load(@NonNull Integer key) {
                        return getInDB(key);
                    }
                });
        cache.get(1);

        // 命中率
        log.debug("{}",cache.stats().hitRate());
        // 被剔除的数量
        log.debug("{}",cache.stats().evictionCount());
        // 加载新值所花费的平均时间[纳秒]
        log.debug("{}",cache.stats().averageLoadPenalty() );
    }
}
