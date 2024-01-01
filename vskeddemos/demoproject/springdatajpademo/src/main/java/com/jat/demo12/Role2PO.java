package com.jat.demo12;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "role2")
@Entity
@SQLDelete(sql = "update role2 set deleted=1 where id=?") //删除语句变为更新语句
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = "Boolean"))//定义一个过滤器
@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")//过滤器参数设置
public class Role2PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -7113302647484900690L;

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "role2PO",orphanRemoval=true,cascade = CascadeType.ALL)
    Set<UserRole2PO> userRoles=new HashSet<>();;

    private Boolean deleted=false;

    public Role2PO() {
    }

    public void addUser(Long userRole2Id,User2PO user2PO){
        UserRole2PO userRole2PO=new UserRole2PO(userRole2Id,user2PO,this);
        userRoles.add(userRole2PO);
        user2PO.getUserRoles().add(userRole2PO);
    }

    public Role2PO(Long id) {
        this.id = id;
    }

    public Role2PO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role2PO(Long id, String name, Set<UserRole2PO> userRoles) {
        this.id = id;
        this.name = name;
        this.userRoles = userRoles;
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

    public Set<UserRole2PO> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole2PO> userRoles) {
        this.userRoles = userRoles;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
