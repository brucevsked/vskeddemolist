package com.jat.system.model.resource;

public class ResourceName {

    private final String name;

    public ResourceName(String name) {
        //最小长度
        int minLength=2;
        //最大长度
        int maxLength=64;

        if(name==null){
            throw new IllegalArgumentException("资源名不能为空！");
        }

        String trimName=name.replace(" ","");
        if("".equals(trimName)){
            throw new IllegalArgumentException("资源名不能为空字符串！");
        }

        if(name.length()<minLength){
            throw new IllegalArgumentException("资源名长度过短！长度应为"+minLength+"～"+maxLength+"个字符");
        }

        if(name.length()>maxLength){
            throw new IllegalArgumentException("资源名长度过长！长度应为"+minLength+"～"+maxLength+"个字符");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
