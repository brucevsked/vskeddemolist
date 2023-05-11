package com.vsked.pattern5a;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class BuildPatternTest {
    private static final Logger log = LoggerFactory.getLogger(BuildPatternTest.class);

    @Test
    public void buildTest(){
        ConcreteBuilder concreteBuilder=new ConcreteBuilder();
        Product product=new Director().constructProduct(concreteBuilder);
        System.out.println(product.getBasic());
    }
}
