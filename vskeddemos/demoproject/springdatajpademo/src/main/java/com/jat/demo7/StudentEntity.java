package com.jat.demo7;

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

@Table(name = "student")//表名
@Entity //实体 表示实体化后可以被跟踪
public class StudentEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 7104943667872517876L;

    @Id //实体实例化后唯一标识 数据库中主键
    @Column(name = "id",columnDefinition = "bigint") //列名与列定义
    private Long id;

    private String name;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name = "studentCourse",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "courseId"))
    private Set<CourseEntity> courseSet;

    public StudentEntity() {
        //要有空构造
    }

    public StudentEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentEntity(Long id, String name, Set<CourseEntity> courseSet) {
        this.id = id;
        this.name = name;
        this.courseSet = courseSet;
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

    public Set<CourseEntity> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<CourseEntity> courseSet) {
        this.courseSet = courseSet;
    }

    @Override
    public String toString() {
        if(courseSet==null){
            return "StudentEntity{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseSet=" + courseSet +
                '}';
    }
}
