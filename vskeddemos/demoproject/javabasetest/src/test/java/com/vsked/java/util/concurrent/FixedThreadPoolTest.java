package com.vsked.java.util.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {

    private static final Logger log = LoggerFactory.getLogger(FixedThreadPoolTest.class);

    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 提交任务到线程池
        for (int i = 0; i < 20; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                log.info("Task " + taskNumber + " is running on " + Thread.currentThread().getName());
                try {
                    // 模拟任务执行时间
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 关闭线程池
        executor.shutdown();
    }
}
