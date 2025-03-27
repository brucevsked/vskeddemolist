package com.jat.controller.model;

import java.util.Date;
import java.util.List;

public class JwtUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;

    private List<String> _roles;

    private List<String> _forces;

    /**
     * 当前用户的角色
     *
     */
    public List<String> getRoles() {
        // 使用的时候写通过数据库查询返回给插件一个角色集合
        return get_roles();
    }

    /**
     * 当前用户的权限
     *
     */
    public List<String> getForces() {
        // 使用的时候写通过数据库查询返回给插件一个角色集合
        return get_forces();
    }

    /**
     * 上次修改密码时间
     *
     */
    public Date getLastModifyPasswordTime() {

        return new Date(System.currentTimeMillis() - 60L * 1000L * 60L * 24);
    }

    public String getUserId() {
        return userId;
    }

    public JwtUser setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public JwtUser setRoles(List<String> roles) {
        this._roles = roles;
        return this;
    }

    public JwtUser setForces(List<String> forces) {
        this._forces = forces;
        return this;
    }

    public List<String> get_roles() {
        return _roles;
    }

    public List<String> get_forces() {
        return _forces;
    }
}
