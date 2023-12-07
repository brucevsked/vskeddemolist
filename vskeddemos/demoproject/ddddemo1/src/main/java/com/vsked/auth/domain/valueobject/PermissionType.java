package com.vsked.auth.domain.valueobject;

public class PermissionType {

    private String permissionTypeName;

    public PermissionType(String permissionTypeName) {
        this.permissionTypeName = permissionTypeName;
    }

    public String getPermissionTypeName() {
        return permissionTypeName;
    }
}
