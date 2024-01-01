package com.jat.demo24;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

@Table(name = "role9")
@Entity
public class Role9PO implements Serializable {
    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 8461077942689697969L;

    @Id
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "rolePermission9",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private Set<Permission9PO> permissions;

    public Role9PO() {
    }

    public Role9PO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role9PO(Long id, String name, Set<Permission9PO> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
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

    public Set<Permission9PO> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission9PO> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", permissions=" + permissions +
                "}";
    }
}
