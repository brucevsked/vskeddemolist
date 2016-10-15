package com.etop.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 网页过滤信息类，保存网页过滤信息，以及对应的权限(一对一)或角色(一对一)
 * <p/>
 * Created by Jeremie on 2014/10/1.
 */
@Entity
@Table(name = "t_function")
public class Function implements Serializable {

    private Integer id;
    private String value;
    private Permission permission;
    private Role role;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @OneToOne
    @JoinColumn(name = "permission_id")
    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @OneToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
