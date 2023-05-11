package com.vsked.DependencyInversionPrinciple.dip;

public class PhoneTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.openApp(new QQ());
        phone.openApp(new TaoBao());
    }

}
