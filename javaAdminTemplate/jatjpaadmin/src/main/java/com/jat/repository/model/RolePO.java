package com.jat.repository.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Table(name = "role")
@Entity
public class RolePO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String descript;
    private Integer isDel;

    @OneToMany(mappedBy = "role",cascade = CascadeType.DETACH)
    List<UserRolePO> userRoles;
    @OneToMany(mappedBy = "role",cascade = CascadeType.DETACH)
    List<RoleResourcePO> roleResources;

    public RolePO() {
    }

    public RolePO(Integer id, String name, String descript, Integer isDel) {
        this.id = id;
        this.name = name;
        this.descript = descript;
        this.isDel = isDel;
    }

    public RolePO(String name, String descript) {
        this.name = name;
        this.descript = descript;
        this.isDel=0;
    }

    public RolePO(Integer id, String name, String descript) {
        this.id = id;
        this.name = name;
        this.descript = descript;
        this.isDel=0;
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

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public List<UserRolePO> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRolePO> userRoles) {
        this.userRoles = userRoles;
    }

    public List<RoleResourcePO> getRoleResources() {
        return roleResources;
    }

    public void setRoleResources(List<RoleResourcePO> roleResources) {
        this.roleResources = roleResources;
    }

    @Override
    public String toString() {
        return "RolePO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}
