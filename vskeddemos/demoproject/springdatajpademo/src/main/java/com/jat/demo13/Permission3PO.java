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

@Table(name = "permission3")
@Entity
@SQLDelete(sql = "update permission3 set deleted=1 where id=?") //删除语句变为更新语句
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = "Boolean"))//定义一个过滤器
@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")//过滤器参数设置
public class Permission3PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 7133559001699669706L;

    @Id
    private Long id;
    private String originalName;
    private String nickName;
    private String description;

    private Boolean deleted=false;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rolePermission3",joinColumns = {@JoinColumn(name = "permissionId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<Role3PO> roles=new LinkedList<>();


    public Permission3PO() {
    }

    public Permission3PO(Long id, String originalName, String nickName, String description) {
        this.id = id;
        this.originalName = originalName;
        this.nickName = nickName;
        this.description = description;
    }

    public Permission3PO(Long id, String originalName, String nickName, String description, List<Role3PO> roles) {
        this.id = id;
        this.originalName = originalName;
        this.nickName = nickName;
        this.description = description;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public List<Role3PO> getRoles() {
        return roles;
    }

    public void setRoles(List<Role3PO> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", originalName='" + originalName  +
                ", nickName=" + nickName  +
                ", description=" + description  +
                ", deleted=" + deleted +
                "}";
    }
}
