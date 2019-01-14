package com.junit5.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Junit5Demo {
	
	private static final Logger log=LogManager.getLogger(Junit5Demo.class);
	
	public int add(int a, int b) {
        int c = a + b;
        log.info("test=="+c);
        return c;
    }

    public int subtract(int a, int b) {
        int d = a - b;
        log.info("result=="+d);
        return d;
    }

}
