package com.vsked.pattern5a;

/**
 *  this is 抽象建造
 *
 */
public interface Builder {

    /**
     * this is 打基础
     */
    public void  buildBasic();
    
    /**
     * this is 砌墙
     */
    public void  buildWalls();
    
    /**
     * this is 封顶
     */
    public void  roofed();
    
    /**
     * this is 造房子
     * @return
     */
    public Product buildProduct();
}
