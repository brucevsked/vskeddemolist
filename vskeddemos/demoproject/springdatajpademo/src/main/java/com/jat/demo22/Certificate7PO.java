package com.jat.demo22;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;


@Table(name = "certificate7")
@Entity
public class Certificate7PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 8509904165051198670L;

    @Id
    private Long id;
    private String content;

    public Certificate7PO() {
    }

    public Certificate7PO(Long id, String content) {
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


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", content=" + content +
                "}";
    }
}
