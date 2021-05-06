package com.vsked.DependencyInversionPrinciple.old;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.openAppQQ(new QQ());
        phone.openAppTaoBao(new TaoBao());
    }

}
