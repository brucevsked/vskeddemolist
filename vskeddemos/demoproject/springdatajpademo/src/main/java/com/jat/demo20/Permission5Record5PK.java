package com.jat.demo20;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;

@Embeddable
public class Permission5Record5PK implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -479721429493047716L;

    @Column(name = "fkpermission")
    private Long permissionId;
    @Column(name = "fkrecord")
    private Long recordId;

    public Permission5Record5PK() {
    }

    public Permission5Record5PK(Long permissionId, Long recordId) {
        this.permissionId = permissionId;
        this.recordId = recordId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String toString() {
        return "{" +
                "permissionId=" + permissionId +
                ", recordId=" + recordId +
                "}";
    }
}
