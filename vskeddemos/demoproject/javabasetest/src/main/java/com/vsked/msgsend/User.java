package com.vsked.msgsend;

public class User {
    private UserId id;
    private UserName name;

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public User(UserId id, UserName name) {
        this.id = id;
        this.name = name;
    }

    public Message send(Message message){
        System.out.println("send:"+message);
        return message;
    }

    public void receive(Message message){
        System.out.println("receive:"+message);
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", name=" + name +
                '}';
    }
}
