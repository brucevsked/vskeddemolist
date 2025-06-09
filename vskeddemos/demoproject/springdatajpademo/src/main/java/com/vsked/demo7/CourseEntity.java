package com.vsked.demo7;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

@Table(name = "course")//表名
@Entity //实体 表示实体化后可以被跟踪
public class CourseEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 7650612985282427812L;

    @Id //实体实例化后唯一标识 数据库中主键
    @Column(name = "id",columnDefinition = "bigint") //列名与列定义
    private Long id;

    private String name;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name = "studentCourse",
            joinColumns = @JoinColumn(name = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "studentId"))
    private Set<StudentEntity> studentSet;

    public CourseEntity() {
        //要有空构造
    }

    public CourseEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourseEntity(Long id, String name, Set<StudentEntity> studentSet) {
        this.id = id;
        this.name = name;
        this.studentSet = studentSet;
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

    public Set<StudentEntity> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<StudentEntity> studentSet) {
        this.studentSet = studentSet;
    }

    @Override
    public String toString() {
        if(studentSet==null){
            return "CourseEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
        return "CourseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentSet=" + studentSet +
                '}';
    }
}
