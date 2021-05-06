package com.vsked.LiskovSubstitutionPrinciple.old;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println("1+2="+computer.calculate(1,2));

        NotebookComputer notebookComputer = new NotebookComputer();
        System.out.println("1+2-3="+notebookComputer.notebookCalculate(1,2,3));
    }

}
