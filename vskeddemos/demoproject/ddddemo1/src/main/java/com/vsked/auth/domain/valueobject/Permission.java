package com.vsked.auth.domain.valueobject;

public class Permission {

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限类型 访问权限，数据权限
     */
    private PermissionType permissionType;

    /**
     * 权限数据，访问类型时是一个地址，数据权限时是可以访问哪些数据
     */
    private Object permissionData;


}
