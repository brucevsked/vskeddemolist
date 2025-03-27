package com.jat.controller.model;

public class ResourceListResourceView {
    private Integer id;
    private String name;
    private String url;
    private String icon;
    private String type;
    private Integer sequence;
    private String parentName;

    public ResourceListResourceView() {
    }

    public ResourceListResourceView(Integer id, String name, String url, String icon, String type, Integer sequence, String parentName) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.type = type;
        this.sequence = sequence;
        this.parentName = parentName;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "ResourceListResourceView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", sequence=" + sequence +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
