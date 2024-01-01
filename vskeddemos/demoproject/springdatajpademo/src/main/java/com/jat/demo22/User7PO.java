package com.jat.demo22;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

@Table(name = "user7")
@Entity
public class User7PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -8459167474173106120L;

    @Id
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userCertificate7",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "certificateId")})
    private Set<Certificate7PO> certificate;

    public User7PO() {
    }

    public User7PO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User7PO(Long id, String name, Set<Certificate7PO> certificate) {
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

    public Set<Certificate7PO> getCertificate() {
        return certificate;
    }

    public void setCertificate(Set<Certificate7PO> certificate) {
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
