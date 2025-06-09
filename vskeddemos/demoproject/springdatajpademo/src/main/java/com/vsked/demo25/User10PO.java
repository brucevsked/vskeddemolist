package com.vsked.demo25;

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

@Table(name = "user10")
@Entity
public class User10PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 8141322234210636375L;

    @Id
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userCertificate10",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "certificateId")})
    private Set<Certificate10PO> certificate;


    public User10PO() {
    }

    public User10PO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User10PO(Long id, String name, Set<Certificate10PO> certificate) {
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

    public Set<Certificate10PO> getCertificate() {
        return certificate;
    }

    public void setCertificate(Set<Certificate10PO> certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "User10PO{" +
                "id=" + id +
                ", name=" + name +
                ", certificate=" + certificate +
                "}";
    }
}
