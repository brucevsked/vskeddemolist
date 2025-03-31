package com.jat.repository.model;

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
@Table(name = "roleResource")
public class RoleResourcePO implements Serializable {

    @EmbeddedId
    private RoleResourcePK id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH )
    @MapsId("roleId")
    @JoinColumn(name = "roleId")
    private RolePO role;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @MapsId("resId")
    @JoinColumn(name = "resId")
    private ResourcePO resource;

    private Integer isDel;

    public RoleResourcePO() {
    }

    public RoleResourcePO(RolePO role, ResourcePO resource,Integer isDel) {
        this.id=new RoleResourcePK(role.getId(),resource.getId());
        this.role = role;
        this.resource = resource;
        this.isDel=isDel;
    }

    public RoleResourcePK getId() {
        return id;
    }

    public void setId(RoleResourcePK id) {
        this.id = id;
    }

    public RolePO getRole() {
        return role;
    }

    public void setRole(RolePO role) {
        this.role = role;
    }

    public ResourcePO getResource() {
        return resource;
    }

    public void setResource(ResourcePO resource) {
        this.resource = resource;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                '}';
    }
}
