package com.jat.controller.model;

public class RoleAddEditResourceView {
    private Integer id;

    public RoleAddEditResourceView() {
    }

    public RoleAddEditResourceView(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        return "{" +
                "id=" + id +
                '}';
    }
}
