package com.jat.controller.model;


import com.jat.system.model.user.User;

public class UserView {
    private Integer id;
    private String name;
    private String phone;

    private Integer state;

    public UserView() {
    }

    public UserView(Integer id, String name, String phone, Integer state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public static UserView userToView(User user){
        return new UserView(user.getId().getId(),user.getName().getName(),user.getPhone().getNumber(),user.getState().getState());
    }
}
