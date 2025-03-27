package com.jat.system.model.account;

import com.jat.util.CryptoTool;

public class AccountPass {

    /**
     * 密码
     */
    private final String password;

    public AccountPass(String password) {
        //最小长度
        int minLength=4;
        //最大长度
        int maxLength=16;

        if(password==null){
            throw new IllegalArgumentException("账户密码不能为空！");
        }
//
//        String trimPassword=password.replace(" ","");
//        if("".equals(trimPassword)){
//            throw new IllegalArgumentException("账户密码不能为空字符串！");
//        }
//
//        if(password.length()<minLength){
//            throw new IllegalArgumentException("账户密码长度过短！长度应为"+minLength+"～"+maxLength+"个字符");
//        }
//
//        if(password.length()>maxLength){
//            throw new IllegalArgumentException("账户密码长度过长！长度应为"+minLength+"～"+maxLength+"个字符");
//        }

        this.password = password;
    }

    public void validOldPassword(String passwordOld){
        if(this.password.equals(passwordOld)){
            throw new IllegalArgumentException("旧密码不能与新密码相同！");
        }
    }

    public void validAgainPassword(String passwordAgain){
        if(!this.password.equals(passwordAgain)){
            throw new IllegalArgumentException("两次输入的密码不一致！");
        }
    }

    public String getEncodePassword(){
        return CryptoTool.md5Encode(this.getPassword());
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return password;
    }
}
