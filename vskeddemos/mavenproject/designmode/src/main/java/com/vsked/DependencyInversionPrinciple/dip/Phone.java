package com.vsked.DependencyInversionPrinciple.dip;

public class Phone {
    public void openApp(App app){
        app.open();
    }
}
