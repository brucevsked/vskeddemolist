package com.vsked.demo6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "grade")//表名
@Entity //实体 表示实体化后可以被跟踪
public class GradeEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -788740932538916854L;

    @Id //实体实例化后唯一标识 数据库中主键
    @Column(name = "id",columnDefinition = "bigint") //列名与列定义
    private Long id;

    private String gradeName;

    public GradeEntity() {
        //要有空构造
    }

    public GradeEntity(Long id, String gradeName) {
        this.id = id;
        this.gradeName = gradeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "GradeEntity{" +
                "id=" + id +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
