package com.vsked.jpa.model;

import java.io.Serializable;
import java.util.Objects;

public class SysRolePermissionId implements Serializable {
    private Long roleid;
    private Long permissionid;

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRolePermissionId that = (SysRolePermissionId) o;
        return Objects.equals(roleid, that.roleid) && Objects.equals(permissionid, that.permissionid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleid, permissionid);
    }
}
