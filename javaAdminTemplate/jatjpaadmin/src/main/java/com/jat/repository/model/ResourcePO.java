package com.jat.repository.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Table(name = "resource")
@Entity
public class ResourcePO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String icon;
    private String type;
    private Integer sequence;
    private Integer parentId;
    private Integer isDel;

    @ManyToOne
    @JoinColumn(name = "parentId",insertable = false,updatable = false)
    ResourcePO parent;

    @OneToMany(mappedBy = "resource",cascade = CascadeType.DETACH)
    List<RoleResourcePO> roleResources;

    public ResourcePO() {
    }

    public ResourcePO(Integer id, String name, String url, String icon, String type, Integer sequence, Integer isDel) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.type = type;
        this.sequence = sequence;
        this.isDel = isDel;
    }

    public ResourcePO(Integer id, String name, String url, String icon, String type, Integer sequence, Integer parentId, Integer isDel) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.type = type;
        this.sequence = sequence;
        this.parentId = parentId;
        this.isDel = isDel;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public ResourcePO getParent() {
        return parent;
    }

    public void setParent(ResourcePO parent) {
        this.parent = parent;
    }

    public List<RoleResourcePO> getRoleResources() {
        return roleResources;
    }

    public void setRoleResources(List<RoleResourcePO> roleResources) {
        this.roleResources = roleResources;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", sequence=" + sequence +
                ", parentId=" + parentId +
                ", isDel=" + isDel +
                '}';
    }
}
