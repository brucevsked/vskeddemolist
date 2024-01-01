package com.jat.demo13;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Table(name = "role3")
@Entity
@SQLDelete(sql = "update role3 set deleted=1 where id=?") //删除语句变为更新语句
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = "Boolean"))//定义一个过滤器
@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")//过滤器参数设置
public class Role3PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 1702454308575429199L;

    @Id
    private Long id;
    private String name;
    private String description;

    private Boolean deleted=false;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rolePermission3",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    List<Permission3PO> permissions=new LinkedList<>();

    public Role3PO() {
    }

    public Role3PO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Role3PO(Long id, String name, String description, List<Permission3PO> permissions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.permissions = permissions;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<Permission3PO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission3PO> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                "}";
    }
}
