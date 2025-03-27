package com.jat.repository.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Table(name = "user")
@Entity
public class UserPO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer state;

    private String phone;

    private Integer isDel;

    @OneToMany(mappedBy = "user",cascade = CascadeType.DETACH)
    List<UserRolePO> userRoles;
    @OneToOne(mappedBy = "user",cascade = CascadeType.DETACH)
    UserAccountPO userAccount;

    public UserPO() {
    }

    public UserPO(Integer id, String name, Integer state, String phone, Integer isDel) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.phone = phone;
        this.isDel = isDel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public List<UserRolePO> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRolePO> userRoles) {
        this.userRoles = userRoles;
    }

    public UserAccountPO getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountPO userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", phone='" + phone + '\'' +
                ", isDel=" + isDel +
                '}';
    }
}
