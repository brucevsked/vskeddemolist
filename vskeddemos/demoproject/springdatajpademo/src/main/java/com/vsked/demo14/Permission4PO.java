package com.vsked.demo14;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;


@Table(name = "permission4")
@Entity
public class Permission4PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 2627183192805173383L;

    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "permissions",cascade = CascadeType.ALL)
    private Set<Role4PO> roles;

    public Permission4PO() {
    }

    public Permission4PO(Long id, String name) {
        this.id = id;
        this.name = name;
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
        return "Permission4PO{" +
                "id=" + id +
                ", name=" + name +
                "}";
    }
}
