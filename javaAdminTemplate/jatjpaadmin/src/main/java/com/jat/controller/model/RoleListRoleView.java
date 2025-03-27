package com.jat.controller.model;

public class RoleListRoleView {
    private Integer id;
    private String name;
    private String descript;

    public RoleListRoleView() {
    }

    public RoleListRoleView(Integer id) {
        this.id = id;
    }

    public RoleListRoleView(Integer id, String name, String descript) {
        this.id = id;
        this.name = name;
        this.descript = descript;
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

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                '}';
    }
}
