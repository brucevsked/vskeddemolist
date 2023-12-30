package com.jat.system.model;

public class Menu {

    private Long id;
    private String name;
    private String url;
    private Menu parent;

    public Menu(Long id, String name, String url, Menu parent) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Menu getParent() {
        return parent;
    }
}
