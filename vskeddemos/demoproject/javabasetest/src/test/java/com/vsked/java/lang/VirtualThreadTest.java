package com.vsked.java.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.concurrent.Executors;

public class VirtualThreadTest {

    private static final Logger log = LoggerFactory.getLogger(VirtualThreadTest.class);
    @Test
    public void test() throws InterruptedException {
        Thread thread = Thread.startVirtualThread(() -> {
            log.debug("Hello, World!");
        });
        thread.join();
    }

    @Test
    public void test2() throws InterruptedException {
        try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
            for(int i = 0; i < 10; i++){
                executor.submit(() -> {
                    log.debug("taskId{}",Thread.currentThread().threadId());
                });
            }

        }
    }


}
