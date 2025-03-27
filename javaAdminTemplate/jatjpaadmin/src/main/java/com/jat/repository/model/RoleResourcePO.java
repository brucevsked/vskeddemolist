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
