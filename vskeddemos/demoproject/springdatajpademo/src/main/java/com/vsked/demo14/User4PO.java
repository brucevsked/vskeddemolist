package com.vsked.demo14;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

@Table(name = "user4")
@Entity
public class User4PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -8144237674707285807L;

    @Id
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userRole4",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Set<Role4PO> roles;

    public User4PO() {
    }

    public User4PO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User4PO(Long id, String name, Set<Role4PO> roles) {
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

    public Set<Role4PO> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role4PO> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User4PO{" +
                "id=" + id +
                ", name=" + name +
                ", roles=" + roles +
                "}";
    }
}
