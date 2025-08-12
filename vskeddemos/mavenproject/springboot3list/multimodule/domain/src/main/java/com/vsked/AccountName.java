package com.vsked;

public class AccountName {

    /**
     * 账户名
     */
    private final String name;

    public AccountName(String name) {
        //最小长度
        int minLength=4;
        //最大长度
        int maxLength=16;

        if(name==null){
            throw new IllegalArgumentException("账户名不能为空！");
        }

        String trimName=name.replace(" ","");
        if(trimName.isEmpty()){
            throw new IllegalArgumentException("账户名不能为空字符串！");
        }

        if(name.length()<minLength){
            throw new IllegalArgumentException("账户名长度过短！长度应为"+minLength+"～"+maxLength+"个字符");
        }

        if(name.length()>maxLength){
            throw new IllegalArgumentException("账户名长度过长！长度应为"+minLength+"～"+maxLength+"个字符");
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
