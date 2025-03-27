package com.jat.repository.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "userRole")
public class UserRolePO implements Serializable {

    @EmbeddedId
    private UserRolePK id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @MapsId("userId")
    @JoinColumn(name = "userId")
    private UserPO user;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @MapsId("roleId")
    @JoinColumn(name = "roleId")
    private RolePO role;

    private Integer isDel;

    public UserRolePO() {
    }

    public UserRolePO(UserPO user, RolePO role) {
        this.id=new UserRolePK(user.getId(),role.getId());
        this.user = user;
        this.role = role;
        this.isDel=0;
    }

    public UserRolePK getId() {
        return id;
    }

    public void setId(UserRolePK id) {
        this.id = id;
    }

    public UserPO getUser() {
        return user;
    }

    public void setUser(UserPO user) {
        this.user = user;
    }

    public RolePO getRole() {
        return role;
    }

    public void setRole(RolePO role) {
        this.role = role;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "UserRolePO{" +
                "id=" + id +
                ", user=" + user +
                ", role=" + role +
                ", isDel=" + isDel +
                '}';
    }
}
