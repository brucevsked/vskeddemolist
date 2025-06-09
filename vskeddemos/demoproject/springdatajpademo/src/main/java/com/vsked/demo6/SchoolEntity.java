package com.vsked.demo6;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

@Table(name = "school")//表名
@Entity //实体 表示实体化后可以被跟踪
public class SchoolEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -2725705185687757266L;

    @Id //实体实例化后唯一标识 数据库中主键
    @Column(name = "id",columnDefinition = "bigint") //列名与列定义
    private Long id;

    private String schoolName;

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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "gradeId")
    private Set<GradeEntity> gradeSet;

    public SchoolEntity() {
        //要有空构造
    }

    public SchoolEntity(Long id, String schoolName) {
        this.id = id;
        this.schoolName = schoolName;
    }

    public SchoolEntity(Long id, String schoolName, Set<GradeEntity> gradeSet) {
        this.id = id;
        this.schoolName = schoolName;
        //if gradeSet!=null ?
        this.gradeSet = gradeSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Set<GradeEntity> getGradeSet() {
        return gradeSet;
    }

    public void setGradeSet(Set<GradeEntity> gradeSet) {
        this.gradeSet = gradeSet;
    }

    @Override
    public String toString() {
        if(gradeSet==null){
            return "SchoolEntity{" +
                    "id=" + id +
                    ", schoolName='" + schoolName + '\'' +
                    '}';
        }

        return "SchoolEntity{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", gradeSet=" + gradeSet +
                '}';
    }
}
