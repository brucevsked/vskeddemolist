package com.vsked.demo23;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

@Table(name = "user8")
@Entity
public class User8PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -8459167474173106120L;

    @Id
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "userCertificate8",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "certificateId")})
    private Set<Certificate8PO> certificate;

    public User8PO() {
    }

    public User8PO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User8PO(Long id, String name, Set<Certificate8PO> certificate) {
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

    public Set<Certificate8PO> getCertificate() {
        return certificate;
    }

    public void setCertificate(Set<Certificate8PO> certificate) {
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
