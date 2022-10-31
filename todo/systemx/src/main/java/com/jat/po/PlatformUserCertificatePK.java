package com.jat.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.Serializable;

@Embeddable
public class PlatformUserCertificatePK implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 1L;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "certificateId")
    private Long certificateId;

    public PlatformUserCertificatePK() {
    }

    public PlatformUserCertificatePK(Long userId, Long certificateId) {
        this.certificateId = certificateId;
        this.userId = userId;
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "{" +
                "userId=" + userId +
                ", certificateId=" + certificateId +
                '}';
    }
}
