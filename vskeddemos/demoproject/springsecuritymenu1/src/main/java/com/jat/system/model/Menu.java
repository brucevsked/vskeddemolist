package com.jat.system.model;

public class Menu {

    private Long id;
    private String name;
    private String url;
    private Menu parent;

    /**
     * 菜单类型 0目录 1菜单 2url 3按钮
     */
    private Integer type;

    public Menu(Long id, String name,Integer type,String url, Menu parent) {
        this.id = id;
        this.name = name;
        this.type=type;
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

    public Integer getType() {
        return type;
    }
}
