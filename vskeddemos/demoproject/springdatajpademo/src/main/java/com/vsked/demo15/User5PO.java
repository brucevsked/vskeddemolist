package com.vsked.demo15;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "user5")
@Entity
public class User5PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 661193861947389412L;

    @Id
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "userCertificate5",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "certificateId")})
    private Certificate5PO certificate;

    public User5PO() {
    }

    public User5PO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User5PO(Long id, String name, Certificate5PO certificate) {
        this.id = id;
        this.name = name;
        this.certificate = certificate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Certificate5PO getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate5PO certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "User5PO{" +
                "id=" + id +
                ", name=" + name +
                ", certificate=" + certificate +
                "}";
    }
}
