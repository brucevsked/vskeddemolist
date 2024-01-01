package com.jat.demo2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "employee")//表名
@Entity //实体 表示实体化后可以被跟踪
public class EmployeeEntity implements Serializable{

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -322544680136793026L;

    @Id //实体实例化后唯一标识 数据库中主键
    @Column(name = "eid",columnDefinition = "bigint") //列名与列定义
    private Long eid;

    @Column(name = "employeeName")
    private String employeeName;

    public EmployeeEntity() {
        //要有空构造
    }

    public EmployeeEntity(Long eid, String employeeName) {
        this.eid = eid;
        this.employeeName = employeeName;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "eid=" + eid +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
