package com.vsked.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Table(name = "a1b1")//表名
@Entity
@IdClass(A1B1Id.class)
public class A1B1 {
    @Id
    private Long a1id;
    @Id
    private Long b1id;
    private Boolean isdel ;
    private LocalDateTime createtime;
    private LocalDateTime deltime;

    public A1B1() {
    }

    public Long getA1id() {
        return a1id;
    }

    public void setA1id(Long a1id) {
        this.a1id = a1id;
    }

    public Long getB1id() {
        return b1id;
    }

    public void setB1id(Long b1id) {
        this.b1id = b1id;
    }

    public Boolean getIsdel() {
        return isdel;
    }

    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getDeltime() {
        return deltime;
    }

    public void setDeltime(LocalDateTime deltime) {
        this.deltime = deltime;
    }

    @Override
    public String toString() {
        return "A1B1{" +
                "a1id=" + a1id +
                ", b1id=" + b1id +
                ", isdel=" + isdel +
                ", createtime=" + createtime +
                ", deltime=" + deltime +
                '}';
    }
}
