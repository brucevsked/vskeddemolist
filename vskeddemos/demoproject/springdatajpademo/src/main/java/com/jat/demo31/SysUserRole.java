package com.jat.demo31;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sysUserRole")
public class SysUserRole implements Serializable {

    @EmbeddedId
    private SysUserRolePK id;

    private Integer isDel;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @MapsId("userId")
    @JoinColumn(name = "userId")
    private SysUser user;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
    @MapsId("roleId")
    @JoinColumn(name = "roleId")
    private SysRole role;

    public SysUserRole() {
    }

    public SysUserRole(SysUser user, SysRole role) {
        this.user = user;
        this.role = role;
        this.isDel=0;
        this.id=new SysUserRolePK(this.getUser().getId(),this.getRole().getId());
    }

    public SysUserRole(Integer isDel, SysUser user, SysRole role) {
        this.isDel = isDel;
        this.user = user;
        this.role = role;
        this.id=new SysUserRolePK(this.getUser().getId(),this.getRole().getId());
    }

    public SysUserRolePK getId() {
        return id;
    }

    public void setId(SysUserRolePK id) {
        this.id = id;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", isDel=" + isDel +
                ", user=" + user +
                ", role=" + role +
                '}';
    }
}
