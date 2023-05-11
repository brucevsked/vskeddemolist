package com.vsked.pattern5a;

/**
 *  this is 建造者
 *
 */
public class Director {
    
    public Product constructProduct(ConcreteBuilder concreteBuilder){
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }

}
