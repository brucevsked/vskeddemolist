package com.vsked.msgsend;

public class UserName {

    private String name;

    public UserName(String name) {
        if(name==null){
            throw new IllegalArgumentException("用户名称不能为空！");
        }

        String nameTrim=name.replace(" ","");
        if("".equals(nameTrim)){
            throw new IllegalArgumentException("用户名称不能为空字符串！");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name ;
    }
}
