package com.vsked.demo11;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;


@Table(name = "actionParameter1")
@Entity
@SQLDelete(sql = "update actionParameter1 set deleted=1 where id=?") //删除语句变为更新语句
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = "Boolean"))//定义一个过滤器
@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")//过滤器参数设置
public class ActionParameterPO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 2175526081883363823L;

    @EmbeddedId
    private ActionParameterPK actionParameterId;

    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @MapsId("actionId")
    @JoinColumn(name = "actionId")
    private ActionPO action;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @MapsId("parameterId")
    @JoinColumn(name = "parameterId")
    private ParameterPO parameter;

    private Boolean deleted=false;

    public ActionParameterPO() {
    }

    public ActionParameterPO(ParameterPO parameter) {
        this.parameter = parameter;
    }

    public ActionParameterPO(Long id, ActionPO action, ParameterPO parameter) {
        this.id = id;
        this.action = action;
        this.parameter = parameter;
        this.actionParameterId=new ActionParameterPK(action.getId(), parameter.getId());
    }

    public ActionParameterPK getActionParameterId() {
        return actionParameterId;
    }

    public void setActionParameterId(ActionParameterPK actionParameterId) {
        this.actionParameterId = actionParameterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ActionPO getAction() {
        return action;
    }

    public void setAction(ActionPO action) {
        this.action = action;
    }

    public ParameterPO getParameter() {
        return parameter;
    }

    public void setParameter(ParameterPO parameter) {
        this.parameter = parameter;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "{" +
                "actionParameterId=" + actionParameterId +
                ", id=" + id +
                ", deleted=" + deleted +
                '}';
    }
}
