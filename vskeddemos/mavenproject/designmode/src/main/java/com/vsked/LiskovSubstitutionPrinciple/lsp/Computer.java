package com.vsked.LiskovSubstitutionPrinciple.lsp;

public class Computer extends Electronics{
    /**
     * 加法
     */
    public int calculate(int num1 ,int num2){
        return num1 + num2;
    }

}
