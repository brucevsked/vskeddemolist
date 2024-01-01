package com.jat.demo20;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "record5")
public class Record5 implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -3778740304052581233L;

    @Id
    private Long id;

    @OneToOne(mappedBy = "record5")
    private Permission5Record5 permissionRecord;

    public Record5() {
    }

    public Record5(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                '}';
    }
}
