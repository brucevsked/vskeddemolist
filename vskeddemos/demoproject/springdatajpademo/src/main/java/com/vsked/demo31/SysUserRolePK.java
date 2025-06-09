package com.vsked.demo31;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SysUserRolePK implements Serializable {

    private Integer userId;

    private Integer roleId;

    public SysUserRolePK() {
    }

    public SysUserRolePK(Integer userId, Integer roleId) {
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

    public String toString() {
        return "{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
