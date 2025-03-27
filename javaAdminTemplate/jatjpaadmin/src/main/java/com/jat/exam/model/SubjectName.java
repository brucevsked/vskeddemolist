package com.jat.exam.model;

public class SubjectName {
    private String name;

    public SubjectName(String name) {
        if(name==null){
            throw new IllegalArgumentException("科目名称不能为空！");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
