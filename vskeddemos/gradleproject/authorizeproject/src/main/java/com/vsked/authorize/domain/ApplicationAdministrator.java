package com.vsked.authorize.domain;

public class ApplicationAdministrator extends ApplicationUsers {

    public ApplicationAdministrator() {
        super.setAdministrator(true);
    }

    public static void main(String[] args) {
        ApplicationAdministrator applicationAdministrator=new ApplicationAdministrator();
        System.out.println(applicationAdministrator.getName()+""+applicationAdministrator.isAdministrator());
    }
}
