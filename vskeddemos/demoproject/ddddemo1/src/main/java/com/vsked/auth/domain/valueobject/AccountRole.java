package com.vsked.auth.domain.valueobject;

import java.util.List;

/**
 * 账户角色
 */
public class AccountRole {

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限
     */
    private List<Permission> permissions;

    public AccountRole(String roleName, List<Permission> permissions) {
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
