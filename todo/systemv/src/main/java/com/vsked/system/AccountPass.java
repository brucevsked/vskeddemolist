package com.vsked.system;

public class AccountPass {
    private String pass;

    public AccountPass(String pass) {
        if(pass==null){
            throw new IllegalArgumentException("account pass not be null！");
        }
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String toString() {
        return pass;
    }
}
