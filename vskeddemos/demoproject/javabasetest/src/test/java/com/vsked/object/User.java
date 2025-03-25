package com.vsked.object;

public class User {
    UserId id;
    UserName name;
    PresentAddress presentAddress;

    public User(UserId id, UserName name, PresentAddress presentAddress) {
        this.id = id;
        this.name = name;
        this.presentAddress = presentAddress;
    }

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public PresentAddress getPresentAddress() {
        return presentAddress;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name +"\""+
                ", \"presentAddress\":\"" + presentAddress +"\""+
                "}";
    }
}
