package com.vsked.web.dto;

import java.util.List;

public class MenuDTO {
    private String path;
    private String component;
    private String redirect;
    private String name;
    private MenuMetaDTO meta;
    private List<MenuDTO> children;

    // Constructors
    public MenuDTO() {}

    public MenuDTO(String path, String component, String name) {
        this.path = path;
        this.component = component;
        this.name = name;
    }

    // Getters and Setters
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuMetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MenuMetaDTO meta) {
        this.meta = meta;
    }

    public List<MenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDTO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "{" +
                "path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", redirect='" + redirect + '\'' +
                ", name='" + name + '\'' +
                ", meta=" + meta +
                ", children=" + children +
                '}';
    }
}

