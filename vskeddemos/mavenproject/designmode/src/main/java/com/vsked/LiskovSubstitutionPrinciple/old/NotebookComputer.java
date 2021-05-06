package com.vsked.LiskovSubstitutionPrinciple.old;

public class NotebookComputer extends Computer{
    public int notebookCalculate(int num1,int num2,int num3){
        //先求和  在求差
        return calculate(num1,num2) - num3;
    }
}
