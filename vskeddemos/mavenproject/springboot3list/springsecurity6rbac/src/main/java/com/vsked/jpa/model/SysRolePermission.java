package com.vsked.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "sysrolepermission")
@IdClass(SysRolePermissionId.class)
public class SysRolePermission {

    @Id
    @Column(name = "roleid")
    private Long roleid;

    @Id
    @Column(name = "permissionid")
    private Long permissionid;

    public SysRolePermission() {
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }

    public SysRolePermission(Long roleid, Long permissionid) {
        this.roleid = roleid;
        this.permissionid = permissionid;
    }

    @Override
    public String toString() {
        return "SysRolePermission{" +
                "roleid=" + roleid +
                ", permissionid=" + permissionid +
                '}';
    }
}
