package com.jat.demo17;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


@Table(name = "certificate6")
@Entity
public class Certificate6 implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 8342607723255268489L;

    @Id
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expireTime;

    public Certificate6() {
    }

    public Certificate6(Long id, Date expireTime) {
        this.id = id;
        this.expireTime = expireTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "Certificate6{" +
                "id=" + id +
                ", expireTime=" + expireTime +
                '}';
    }
}
