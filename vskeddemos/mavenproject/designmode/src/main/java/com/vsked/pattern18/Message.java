package com.vsked.pattern18;

/**
 * 通知者抽象者
 *
 */
public interface Message {

    public void Add(Observer observer);//增加观察者

    public void delete(Observer observer);//删除观察者

    public void notice();
}
