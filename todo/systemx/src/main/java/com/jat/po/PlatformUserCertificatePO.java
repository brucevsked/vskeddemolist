package com.jat.po;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "platformUserCertificate")
public class PlatformUserCertificatePO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PlatformUserCertificatePK id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",insertable = false,updatable = false)
    private PlatformUserPO user;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "certificateId",insertable = false,updatable = false)
    private PlatformCertificatePO certificate;

    public PlatformUserCertificatePO() {
    }

    public PlatformUserCertificatePO(PlatformUserPO user, PlatformCertificatePO certificate) {
        this.id=new PlatformUserCertificatePK(user.getId(),certificate.getId());
        this.user = user;
        this.certificate = certificate;
    }

    public PlatformUserCertificatePK getId() {
        return id;
    }

    public void setId(PlatformUserCertificatePK id) {
        this.id = id;
    }

    public PlatformUserPO getUser() {
        return user;
    }

    public void setUser(PlatformUserPO user) {
        this.user = user;
    }

    public PlatformCertificatePO getCertificate() {
        return certificate;
    }

    public void setCertificate(PlatformCertificatePO certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", user=" + user +
                ", certificate=" + certificate +
                '}';
    }
}
