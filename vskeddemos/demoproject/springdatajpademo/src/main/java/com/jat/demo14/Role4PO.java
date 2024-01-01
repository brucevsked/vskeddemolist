package com.jat.demo14;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Table(name = "role4")
@Entity
public class Role4PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 7090775343561513801L;

    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    private Set<User4PO> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rolePermission4",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<Permission4PO> permissions;

    public Role4PO() {
    }

    public Role4PO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role4PO(Long id, String name, List<Permission4PO> permissions) {
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

    public Set<User4PO> getUsers() {
        return users;
    }

    public void setUsers(Set<User4PO> users) {
        this.users = users;
    }

    public List<Permission4PO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission4PO> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role4PO{" +
                "id=" + id +
                ", name=" + name +
                ", permissions=" + permissions +
                '}';
    }
}
