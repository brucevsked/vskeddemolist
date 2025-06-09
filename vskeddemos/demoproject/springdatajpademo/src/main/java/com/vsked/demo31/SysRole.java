package com.vsked.demo31;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Table(name = "sysRole")
@Entity
public class SysRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer isDel;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    List<SysUserRole> userRoles;

    public SysRole() {
    }

    public SysRole(String name) {
        this.name = name;
        this.isDel=0;
    }

    public SysRole(Integer id, String name, Integer isDel) {
        this.id = id;
        this.name = name;
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public List<SysUserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<SysUserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDel=" + isDel +
                ", userRoles=" + userRoles +
                '}';
    }
}
