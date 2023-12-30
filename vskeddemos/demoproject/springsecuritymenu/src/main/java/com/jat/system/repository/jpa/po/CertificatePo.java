package com.jat.system.repository.jpa.po;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Table(name = "certificate")
@Entity
public class CertificatePo implements Serializable {

    @Transient
    private static final long serialVersionUID = -3054004465172100952L;

    @Id
    @GeneratedValue(generator = "myIdGeneratorConfig",strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "myIdGeneratorConfig",strategy = "com.jat.common.Snowflake")
    private Long id;
    private Date expireTime;

    public CertificatePo() {
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
}
