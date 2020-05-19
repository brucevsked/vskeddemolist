package com.vsked.authorize.domain;

public class ApplicationUsers {

    private String name="myname";
    private boolean isAdministrator=false;

    public String getName() {
        return name;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }
}
