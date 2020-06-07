package com.vsked.pattern16a;

/**
 *  this is 具体的策略<离间计>
 *
 */
public class DetailStrategy implements StrategyInterface{

    /**
     *  this is 具体策略
     */
    public void excit() {
        System.out.println("hi gay,给你个离间计 这里是具体策略实现");
    }

}
