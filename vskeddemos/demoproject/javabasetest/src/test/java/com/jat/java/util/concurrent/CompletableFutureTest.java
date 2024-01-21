package com.jat.java.util.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 任务编排
 * Task arrangement
 */
public class CompletableFutureTest {
    private static final Logger log = LoggerFactory.getLogger(CompletableFutureTest.class);

    //------------------start depend relationship |开始 依赖关系

    @Test
    public void thenApplyTest1() throws ExecutionException, InterruptedException {
        //hand over the previous execution results to the back
        //把前面任务的执行结果，交给后面函数执行
        log.trace("thenApplyTest1");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int a = 100;
            a = a + 1;
            System.out.println("first operation|第一次运算 :" + a);
            return a;
        }).thenApply(number -> {
            int b = number;
            System.out.println("previous operation result|上一次运算结果 :" + b);
            b = b * 2;
            System.out.println("second operation|第二次运算 :" + b);
            return b;
        });

        int result = future.get();
        log.debug("{}", result);
    }

    @Test
    public void thenApplyTest2() throws ExecutionException, InterruptedException {
        //hand over the previous execution results to the back
        //把前面任务的执行结果，交给后面函数执行
        log.trace("thenApplyTest2");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int a = 100;
            a = a + 1;
            System.out.println("first operation|第一次运算 :" + a);
            return a;
        }).thenApply(number -> {
            int b = number;
            System.out.println("previous operation result|上一次运算结果 :" + b);
            b = b * 2;
            System.out.println("second operation|第二次运算 :" + b);
            return b;
        }).thenApply(number -> {
            int c = number;
            System.out.println("previous operation result|上一次运算结果 :" + c);
            c = c + 1;
            System.out.println("third operation|第三次运算 :" + c);
            return c;
        });

        int result = future.get();
        log.debug("{}", result);

    }

    @Test
    public void thenComposeTest() throws ExecutionException, InterruptedException {
        //connect two tasks with dependencies,and the result is returned by the second task
        //连接两个有依赖关系的任务，结果由第二个任务返回

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int a = 100;
            a = a + 1;
            System.out.println("first operation|第一次运算 :" + a);
            return a;
        }).thenCompose(number -> CompletableFuture.supplyAsync(() -> {
            int b = number;
            System.out.println("previous operation result|上一次运算结果 :" + b);
            b = b * 2;
            System.out.println("second operation|第二次运算 :" + b);
            return b;
        }));

        int result = future.get();
        log.debug("{}", result);

    }

    //thenApply and thenCompose different| thenApply and thenCompose 区别
    //thenApply converts types in generics,and returns the same CompletableFuture |thenApply 转换的是泛型中的类型，返回的是同一个CompletableFuture
    //thenCompose将内部的CompletableFuture调用展开,并使用上一个CompletableFuture调用的结果在下一步的CompletableFuture调用中进行运算，是生成一个新的CompletableFuture

    //------------------end depend relationship |结束 依赖关系

    //------------------start and set relationship |开始 并且集合关系
    //------------------end and relationship |结束 并且集合关系

    //------------------start or aggregation relationship |开始 或者聚合关系
    //------------------end or aggregation relationship |结束 或者聚合关系

    //------------------start parallel |开始 并行执行

    @Test
    public void allOfTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            String s1 = "ok1";
            System.out.println("first operation|第一次运算 :" + s1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return s1;
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            String s1 = "ok2";
            System.out.println("first operation|第一次运算 :" + s1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return s1;
        });

        CompletableFuture<Void> comboFuture=CompletableFuture.allOf(future1,future2);

        comboFuture.get();
        log.debug("all task finish.");

    }


    //------------------end parallel |结束 并行执行

    //------------------start result processing |开始 结果处理
    //------------------end result processing |结束 结果处理

}
