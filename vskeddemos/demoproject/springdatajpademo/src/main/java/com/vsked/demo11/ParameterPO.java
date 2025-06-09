package com.vsked.demo11;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;


@Table(name = "parameter1")
@Entity
@SQLDelete(sql = "update parameter1 set deleted=1 where id=?") //删除语句变为更新语句
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = "Boolean"))//定义一个过滤器
@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")//过滤器参数设置
public class ParameterPO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 677991687800853429L;

    @Id
    private Long id;
    private Integer sequence;
    private String type;
    private String name;
    private Boolean deleted=false;

    public ParameterPO() {
    }

    public ParameterPO(Long id, Integer sequence, String type, String name) {
        this.id = id;
        this.sequence = sequence;
        this.type = type;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id=" + id +
                ", sequence=" + sequence +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                "}";
    }
}
