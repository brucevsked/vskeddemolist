package com.jat.java.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Random;

public class RandomTest {
    private static final Logger log = LoggerFactory.getLogger(RandomTest.class);

    @Test
    public void randomInt() {
        Random random = new Random();
        int a = random.nextInt();
        log.debug("{}", a);
    }

    @Test
    public void randomIntCustomer() {
        Random random = new Random();
        int a = random.nextInt(10);//0-9的随机数 a>=0 a<=9
        log.debug("{}", a);
        int b = 11 + a;//10-20随机数 b>=11 b<=20
        log.debug("{}", b);

    }
}
