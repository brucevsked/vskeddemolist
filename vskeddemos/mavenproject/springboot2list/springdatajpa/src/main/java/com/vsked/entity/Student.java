package com.vsked.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "student")
@Entity
public class Student {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "sname")
    private String sname;

    public Student() {
    }

    public Student(long id, String sname) {
        this.id = id;
        this.sname = sname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
