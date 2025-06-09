package com.vsked.demo20;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "permissionRecord5")
public class Permission5Record5 implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -8002775002403230309L;

    @EmbeddedId
    private Permission5Record5PK id;
    private Long typeId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fkpermission",insertable = false,updatable = false)
    private Permission5 permission5;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "fkrecord",insertable = false,updatable = false)
    private Record5 record5;

    public Permission5Record5() {
    }

    //推荐用此方案，表达更清楚
    public Permission5Record5(Long typeId, Permission5 permission5, Record5 record5) {
        this.id=new Permission5Record5PK(permission5.getId(),record5.getId());//注意这里
        this.typeId = typeId;
        this.permission5 = permission5;
        this.record5 = record5;
    }

    public Permission5Record5(Permission5Record5PK id, Long typeId,String permissionName) {
        this.id = id;
        this.typeId = typeId;
        this.permission5 = new Permission5(id.getPermissionId(),permissionName);
        this.record5 = new Record5(id.getRecordId());
    }

    public Permission5Record5PK getId() {
        return id;
    }

    public void setId(Permission5Record5PK id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Permission5 getPermission5() {
        return permission5;
    }

    public void setPermission5(Permission5 permission5) {
        this.permission5 = permission5;
    }

    public Record5 getRecord5() {
        return record5;
    }

    public void setRecord5(Record5 record5) {
        this.record5 = record5;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", record5=" + record5 +
                "}";
    }
}
