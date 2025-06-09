package com.vsked.demo17;

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

@Table(name = "user6")
@Entity
public class User6 implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 3039961336619993497L;

    @Id
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "userCertificate6",joinColumns = {@JoinColumn(name = "userId")},inverseJoinColumns = {@JoinColumn(name = "certificateId")})
    private Set<Certificate6> certificates;

    public User6() {
    }

    public User6(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<Certificate6> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<Certificate6> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "User6{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", certificates=" + certificates +
                '}';
    }
}
