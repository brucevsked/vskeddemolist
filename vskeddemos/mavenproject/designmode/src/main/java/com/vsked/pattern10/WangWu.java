package com.vsked.pattern10;

/**
 * 3实际执行动作的人，受保护的人王五
 */
public class WangWu implements Person{

    @Override
    public void buyTicket() {
        System.out.println("买名字为王五的的票");
    }
}
