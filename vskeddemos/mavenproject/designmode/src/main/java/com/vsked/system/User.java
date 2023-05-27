package com.vsked.system;

public class User {
    private Id id;
    private UserName name;
    private Account account;

    //TODO user state

    public User(Id id, UserName name, Account account) {
        if(id==null){
            throw new IllegalArgumentException("user id not be null！");
        }
        if(name==null){
            throw new IllegalArgumentException("user name not be null！");
        }
        if(account==null){
            throw new IllegalArgumentException("user account not be null！");
        }
        this.id = id;
        this.name = name;
        this.account = account;
    }

    public void login(Account account){
        //todo has permission out
        //state can login

        account.validate(this.account);
    }

    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name  +
                ", account=" + account +
                "}";
    }
}
