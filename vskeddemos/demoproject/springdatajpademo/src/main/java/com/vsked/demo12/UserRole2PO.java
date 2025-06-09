package com.vsked.demo12;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "userRole2")
@Entity
@SQLDelete(sql = "update userRole2 set deleted=1 where id=?") //删除语句变为更新语句
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = "Boolean"))//定义一个过滤器
@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")//过滤器参数设置
public class UserRole2PO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 2077239613239070685L;

    @EmbeddedId
    UserRole2PK userRole2PK;

    @Column(name = "id")
    private Long id;
    private Boolean deleted=false;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @MapsId("userId")
    @JoinColumn(name = "userId")
    private User2PO user2PO;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @MapsId("roleId")
    @JoinColumn(name = "roleId")
    private Role2PO role2PO;

    public UserRole2PO() {
    }

    public UserRole2PO(Long id, User2PO user2PO, Role2PO role2PO) {
        this.id = id;
        this.user2PO = user2PO;
        this.role2PO = role2PO;
        this.userRole2PK=new UserRole2PK(user2PO.getId(),role2PO.getId());
    }

    public UserRole2PK getUserRole2PK() {
        return userRole2PK;
    }

    public void setUserRole2PK(UserRole2PK userRole2PK) {
        this.userRole2PK = userRole2PK;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public User2PO getUser2PO() {
        return user2PO;
    }

    public void setUser2PO(User2PO user2PO) {
        this.user2PO = user2PO;
    }

    public Role2PO getRole2PO() {
        return role2PO;
    }

    public void setRole2PO(Role2PO role2PO) {
        this.role2PO = role2PO;
    }
}
