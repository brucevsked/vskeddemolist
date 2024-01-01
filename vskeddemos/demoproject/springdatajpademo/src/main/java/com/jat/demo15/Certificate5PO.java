package com.jat.demo15;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;


@Table(name = "certificate5")
@Entity
public class Certificate5PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -4996099625666042353L;

    @Id
    private Long id;
    private String content;

    @OneToOne(mappedBy = "certificate")
    private User5PO user;

    public Certificate5PO() {
    }

    public Certificate5PO(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User5PO getUser() {
        return user;
    }

    public void setUser(User5PO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Certificate5PO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
