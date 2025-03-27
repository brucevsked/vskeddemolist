package com.jat.controller.model;

import java.util.List;

public class MenuView {
    private Integer id;
    private String icon;
    private String index;
    private String title;
    private List<MenuView> subs;

    public MenuView() {
    }

    public MenuView(Integer id, String icon, String index, String title) {
        this.id=id;
        this.icon = icon;
        this.index = index;
        this.title = title;
    }

    public MenuView(Integer id, String icon, String index, String title, List<MenuView> subs) {
        this.id=id;
        this.icon = icon;
        this.index = index;
        this.title = title;
        this.subs = subs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuView> getSubs() {
        return subs;
    }

    public void setSubs(List<MenuView> subs) {
        this.subs = subs;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", index='" + index + '\'' +
                ", title='" + title + '\'' +
                ", subs=" + subs +
                '}';
    }
}
