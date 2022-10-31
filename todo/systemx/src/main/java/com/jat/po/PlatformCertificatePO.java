package com.jat.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "platformCertificate")
@Entity
public class PlatformCertificatePO implements Serializable {

    @Transient
    private static final long serialVersionUID = -3054004465172100952L;

    @Id
    private Long id;
    private LocalDateTime expireTime;

    public PlatformCertificatePO() {
    }

    public PlatformCertificatePO(Long id, LocalDateTime expireTime) {
        this.id = id;
        this.expireTime = expireTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", expireTime=" + expireTime +
                '}';
    }
}
