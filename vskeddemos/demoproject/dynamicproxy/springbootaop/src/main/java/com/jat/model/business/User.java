package com.jat.model.business;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer id=1;
    private String name="bruce";

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        System.out.println("user id:"+id);
        return id;
    }

    public String getName() {
        System.out.println("user name:"+name);
        return name;
    }

    public void run(Integer speed,String roadName){
        System.out.println("user run speed:"+speed+",roadName:"+roadName);
    }

    public String jump(Integer hight){
        System.out.println("user jump height:"+hight);
        return "user jump:"+hight;
    }
}
