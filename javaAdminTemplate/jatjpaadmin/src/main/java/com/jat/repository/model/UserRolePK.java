package com.jat.repository.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserRolePK implements Serializable {

    private Integer userId;

    private Integer roleId;

    public UserRolePK() {
    }

    public UserRolePK(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
