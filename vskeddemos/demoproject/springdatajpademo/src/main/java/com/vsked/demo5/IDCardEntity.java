package com.vsked.demo5;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "IDCard")//表名
@Entity //实体 表示实体化后可以被跟踪
public class IDCardEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 5817406696205504851L;

    @Id
    @Column(name = "id")
    private String id;

    private String personName;

    private String birthday;

    private byte sex;

    public IDCardEntity() {
    }

    public IDCardEntity(String id, String personName, String birthday, byte sex) {
        this.id = id;
        this.personName = personName;
        this.birthday = birthday;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "IDCardEntity{" +
                "id='" + id + '\'' +
                ", personName='" + personName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex=" + sex +
                '}';
    }
}
