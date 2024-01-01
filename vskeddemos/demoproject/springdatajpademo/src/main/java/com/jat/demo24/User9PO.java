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

@Table(name = "user9")
@Entity
public class User9PO implements Serializable {
    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 6236543700993128419L;

    @Id
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "userRole9",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Set<Role9PO> roles;

    public User9PO() {
    }

    public User9PO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User9PO(Long id, String name, Set<Role9PO> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
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

    public Set<Role9PO> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role9PO> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", roles=" + roles +
                "}";
    }
}
