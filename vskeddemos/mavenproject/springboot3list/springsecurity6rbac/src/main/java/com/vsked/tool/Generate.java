package com.vsked.tool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 订单号生成器
 */
public class Generate {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private long currentSecond = 0;
    private int currentSecondCount = 1;
    private final Lock lock = new ReentrantLock();

    /**
     * 生成格式为yyyyMMddHHmmss001，后面数字会递增，支持多线程与线程池
     * @return yyyyMMddHHmmss001
     */
    public String genNumber(){
        lock.lock();
        try {
            LocalDateTime now = LocalDateTime.now();
            String formatted = now.format(FORMATTER);
            long tempCurrentSecond = Long.parseLong(formatted);

            // 如果时间戳发生变化，重置计数器
            if (tempCurrentSecond != currentSecond) {
                currentSecond = tempCurrentSecond;
                currentSecondCount = 1;
            }

            // 构造编号
            String sb = formatted + "0".repeat(Math.max(0, 3 - String.valueOf(currentSecondCount).length())) + currentSecondCount;

            // 计数器递增
            currentSecondCount++;

            return sb;
        } finally {
            lock.unlock(); // 确保锁总是被释放
        }
    }

    public static void main(String[] args) {
        Generate generate=new Generate();
        String s=generate.genNumber();
        System.out.println("|"+s+"|");


        // 创建一个固定大小的线程池
        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {

            // 提交任务到线程池
            for (int i = 0; i < 200; i++) {
                executor.submit(() -> {
                    //System.out.println("Task " + taskNumber + " is running on " + Thread.currentThread().getName());
                    String goodSeq = generate.genNumber();
                    System.out.println("|" + goodSeq + "|");
                });
            }

            // 关闭线程池
            executor.shutdown();
        }
    }
}
