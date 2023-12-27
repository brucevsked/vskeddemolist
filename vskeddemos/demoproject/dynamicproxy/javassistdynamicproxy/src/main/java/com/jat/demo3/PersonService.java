package com.jat.demo3;

/**
 * 修改现有类<br>
 *   比如常见的日志切面，权限切面。我们利用javassist来实现这个功能。
 */
public class PersonService {

    public void getPerson(){
        System.out.println("只要你的人，不要你的心。");
    }

    public void personFly(){
        System.out.println("飞得更高，让他默默向上吧");
    }
}
