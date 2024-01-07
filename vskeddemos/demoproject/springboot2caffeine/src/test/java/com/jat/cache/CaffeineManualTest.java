package com.jat.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * 手动填充数据
 */
public class CaffeineManualTest {
    private static final Logger log = LoggerFactory.getLogger(CaffeineManualTest.class);

    @Test
    public void test() {
        // 初始化缓存，设置了1分钟的写过期，100的缓存最大个数
        Cache<Integer, Integer> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .maximumSize(100)
                .build();
        int key1 = 1;
        // 使用getIfPresent方法从缓存中获取值。如果缓存中不存指定的值，则方法将返回 null：
        log.debug("{}",cache.getIfPresent(key1));

        // 也可以使用 get 方法获取值，该方法将一个参数为 key 的 Function 作为参数传入。如果缓存中不存在该 key
        // 则该函数将用于提供默认值，该值在计算后插入缓存中：
        log.debug("{}",cache.get(key1, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return 2;
            }
        }));

        // 校验key1对应的value是否插入缓存中
        log.debug("{}",cache.getIfPresent(key1));

        // 手动put数据填充缓存中
        int value1 = 2;
        cache.put(key1, value1);

        // 使用getIfPresent方法从缓存中获取值。如果缓存中不存指定的值，则方法将返回 null：
        log.debug("{}",cache.getIfPresent(1));

        // 移除数据，让数据失效
        cache.invalidate(1);
        log.debug("{}",cache.getIfPresent(1));
    }
}
