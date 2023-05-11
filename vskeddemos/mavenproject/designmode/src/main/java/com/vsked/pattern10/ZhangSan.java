package com.vsked.pattern10;

/**
 * 2代理人,用来保护实际使用动作的人，动作可以是一个，也可以是多个
 */
public class ZhangSan implements Person{

    private Person person=null;

    public ZhangSan() {
        this.person=this;
    }

    public ZhangSan(Person person) {
        this.person = person;
    }

    @Override
    public void buyTicket() {
        //是买自己的票，还是帮别人买票
        if(this.person instanceof ZhangSan){
            System.out.println("买张三的票");
        }else{
            this.person.buyTicket();
        }

    }
}
