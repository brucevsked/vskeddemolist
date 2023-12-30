package com.jat.system.model;

import java.util.List;

public class Role {

    private Long id;
    private String name;
    private List<Menu> menus;

    public Role(Long id, String name, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.menus = menus;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
