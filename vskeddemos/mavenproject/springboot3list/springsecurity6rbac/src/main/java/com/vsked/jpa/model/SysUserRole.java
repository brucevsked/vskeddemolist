package com.vsked.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "sysuserrole")
@IdClass(SysUserRoleId.class)
public class SysUserRole {

    @Id
    @Column(name = "userid")
    private Long userid;

    @Id
    @Column(name = "roleid")
    private Long roleid;

    public SysUserRole() {
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
                "userid=" + userid +
                ", roleid=" + roleid +
                '}';
    }
}