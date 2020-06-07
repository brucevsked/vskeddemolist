package com.vsked.authorize.domain;

public class ApplicationUser extends ApplicationUsers{

    public ApplicationUser() {
        
        super.setAdministrator(false);
    }

    public static void main(String[] args) {
        ApplicationUser applicationUser=new ApplicationUser();

        System.out.println(applicationUser.getName()+""+applicationUser.isAdministrator());
    }
}
