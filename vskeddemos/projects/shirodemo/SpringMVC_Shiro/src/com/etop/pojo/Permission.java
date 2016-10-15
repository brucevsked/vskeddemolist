package com.etop.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限类，保存权限信息与对应的角色（多对一）
 * <p/>
 * Created by Jeremie on 2014/10/1.
 */

@Entity
@Table(name = "t_permission")
public class Permission implements Serializable {

    private Integer id;
    private String permissionname;
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    @ManyToOne(targetEntity = Role.class)
    @JoinTable(name = "t_role_permission", joinColumns = {@JoinColumn(name = "permission_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}