package com.jat.repository.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RoleResourcePK implements Serializable {

    private Integer roleId;
    private Integer resId;

    public RoleResourcePK() {
    }

    public RoleResourcePK(Integer roleId, Integer resId) {
        this.roleId = roleId;
        this.resId = resId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "{" +
                "roleId=" + roleId +
                ", resId=" + resId +
                '}';
    }
}
