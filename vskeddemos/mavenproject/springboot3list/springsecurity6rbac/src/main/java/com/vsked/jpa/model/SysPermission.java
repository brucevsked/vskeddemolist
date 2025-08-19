package com.vsked.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "syspermission")
public class SysPermission {

    @Id
    private Long id;

    private String name;

    private Integer resourcetype;

    private Integer action;

    private Long resourceid;

    @Column(columnDefinition = "TEXT")
    private String attributejson;

    public SysPermission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(Integer resourcetype) {
        this.resourcetype = resourcetype;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

    public String getAttributejson() {
        return attributejson;
    }

    public void setAttributejson(String attributejson) {
        this.attributejson = attributejson;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resourcetype=" + resourcetype +
                ", action=" + action +
                ", resourceid=" + resourceid +
                ", attributejson='" + attributejson + '\'' +
                '}';
    }
}