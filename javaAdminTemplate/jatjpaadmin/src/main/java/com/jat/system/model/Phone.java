package com.jat.system.model;

public class Phone {
    private String number;

    public Phone(String number) {
        if(number==null){
            throw new IllegalArgumentException("手机号不能为空！");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number ;
    }
}
