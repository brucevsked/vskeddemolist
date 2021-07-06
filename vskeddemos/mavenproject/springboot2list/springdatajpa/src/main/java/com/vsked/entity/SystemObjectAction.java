package com.vsked.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@IdClass(SystemObjectActionPK.class)
@Table(name = "systemObjectAction")
@Entity
public class SystemObjectAction implements Serializable {

    private Long systemObjectId;
    private Long objectActionId;


    @Id
    public Long getSystemObjectId() {
        return systemObjectId;
    }

    @Id
    public Long getObjectActionId() {
        return objectActionId;
    }

    public void setSystemObjectId(Long systemObjectId) {
        this.systemObjectId = systemObjectId;
    }

    public void setObjectActionId(Long objectActionId) {
        this.objectActionId = objectActionId;
    }

    public SystemObjectAction() {
    }

    public SystemObjectAction(Long systemObjectId, Long objectActionId) {
        this.systemObjectId = systemObjectId;
        this.objectActionId = objectActionId;
    }

}
