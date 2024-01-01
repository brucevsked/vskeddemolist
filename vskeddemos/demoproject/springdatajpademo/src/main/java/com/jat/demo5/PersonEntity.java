package com.jat.demo5;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "person")//表名
@Entity //实体 表示实体化后可以被跟踪
public class PersonEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 6503195034044299043L;

    @Id //实体实例化后唯一标识 数据库中主键
    @Column(name = "id",columnDefinition = "bigint") //列名与列定义
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * Spring Data Jpa 中级联操作CascadeType的含义
     * CascadeType.PERSIST
     *
     * 级联新增，保存父对象时会新建其中包含的子对象
     *
     * CascadeType.MERGE
     * 级联修改，保存父对象时会更新其中所包含的子对象数据
     *
     * CascadeType.REMOVE
     * 级联删除，当删除关联关系时会将子对象的数据删除
     *
     * CascadeType.REFRESH
     * 级联刷新，保存关联关系时会更新子对象和数据库中一致
     * (意思是你在父对象中添加一个只包含ID的子对象，也可以保存进去)
     *
     * CascadeType.ALL
     * 包含上述所有操作
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCardId",referencedColumnName = "id")
    private IDCardEntity idCardEntity;

    public PersonEntity() {
    }

    public PersonEntity(Long id, String name, IDCardEntity idCardEntity) {
        this.id = id;
        this.name = name;
        this.idCardEntity = idCardEntity;
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

    public IDCardEntity getIdCardEntity() {
        return idCardEntity;
    }

    public void setIdCardEntity(IDCardEntity idCardEntity) {
        this.idCardEntity = idCardEntity;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCardEntity=" + idCardEntity +
                '}';
    }
}
