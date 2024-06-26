package com.jat.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseUserRole<M extends BaseUserRole<M>> extends Model<M> implements IBean {

	/**
	 * 用户编号
	 */
	public M setUserId(java.lang.Integer userId) {
		set("userId", userId);
		return (M)this;
	}
	
	/**
	 * 用户编号
	 */
	public java.lang.Integer getUserId() {
		return getInt("userId");
	}
	
	/**
	 * 角色编号
	 */
	public M setRoleId(java.lang.Integer roleId) {
		set("roleId", roleId);
		return (M)this;
	}
	
	/**
	 * 角色编号
	 */
	public java.lang.Integer getRoleId() {
		return getInt("roleId");
	}
	
	/**
	 * 0表示有效  1表示无效
	 */
	public M setIsDel(java.lang.Integer isDel) {
		set("isDel", isDel);
		return (M)this;
	}
	
	/**
	 * 0表示有效  1表示无效
	 */
	public java.lang.Integer getIsDel() {
		return getInt("isDel");
	}
	
}

