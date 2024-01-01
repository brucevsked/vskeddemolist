package com.jat.demo20;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "permission5")
public class Permission5 implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 93266762769087747L;

    @Id
    private Long id;
    private String name;

    @OneToOne(mappedBy = "permission5",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Permission5Record5 permissionRecord;

    public Permission5() {
    }

    public Permission5(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permission5Record5 getPermissionRecord() {
        return permissionRecord;
    }

    public void setPermissionRecord(Permission5Record5 permissionRecord) {
        this.permissionRecord = permissionRecord;
    }

    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", permissionRecord=" + permissionRecord +
                "}";
    }
}
