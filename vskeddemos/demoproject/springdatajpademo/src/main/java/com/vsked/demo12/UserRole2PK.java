package com.vsked.demo12;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;

@Embeddable
public class UserRole2PK implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 5423761506290467796L;

    private Long userId;
    private Long roleId;

    public UserRole2PK() {
    }

    public UserRole2PK(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
