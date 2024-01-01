package com.jat.demo11;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;

@Embeddable
public class ActionParameterPK implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -4890981914634880255L;

    @Column(name = "actionId")
    private Long actionId;
    @Column(name = "parameterId")
    private Long parameterId;

    public ActionParameterPK() {
    }

    public ActionParameterPK(Long actionId, Long parameterId) {
        this.actionId = actionId;
        this.parameterId = parameterId;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    @Override
    public String toString() {
        return "{" +
                "actionId=" + actionId +
                ", parameterId=" + parameterId +
                '}';
    }
}
