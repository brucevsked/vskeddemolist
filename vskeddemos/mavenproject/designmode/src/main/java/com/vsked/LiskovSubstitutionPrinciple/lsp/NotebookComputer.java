package com.vsked.LiskovSubstitutionPrinciple.lsp;

public class NotebookComputer extends Electronics{
    //依赖Computer类
    private Computer computer = new Computer();

    /**
     * 先加法 后减法
     */
    public int calculate(int num1 ,int num2,int num3){
        return computer.calculate(num1,num2) - num3;
    }
}
