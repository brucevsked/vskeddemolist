package com.vsked.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class CarTest {

    private static final Logger log = LoggerFactory.getLogger(CarTest.class);

    public static void main(String[] args) {
        Car car=new Car();
        car.run();
    }

    @Test
    public void t1(){
        Car car=new Car();
        car.run();
    }

}
