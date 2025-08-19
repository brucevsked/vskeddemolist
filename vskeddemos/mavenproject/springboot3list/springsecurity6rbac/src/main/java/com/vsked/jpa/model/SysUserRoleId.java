// 联合主键类
package com.vsked.jpa.model;

import java.io.Serializable;
import java.util.Objects;

public class SysUserRoleId implements Serializable {
    private Long userid;
    private Long roleid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserRoleId that = (SysUserRoleId) o;
        return Objects.equals(userid, that.userid) && Objects.equals(roleid, that.roleid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, roleid);
    }
}