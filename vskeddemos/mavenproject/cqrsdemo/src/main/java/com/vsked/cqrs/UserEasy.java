package com.vsked.cqrs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 简单版本读数据与写数据用的是同一份数据可以理解为同一张表
 * @author vsked
 *
 */
@Entity
@Table(name="usereasy")
public class UserEasy {
	
	@Id
	private Integer userId;
	private String userName;
	private String userPass;
	
	public UserEasy(String userName) {
		super();
		this.userName = userName;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}
	
	public UserEasy() {
		super();
	}

	public UserEasy(Integer userId) {
		super();
		this.userId = userId;
	}

	public UserEasy(Integer userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public String toString() {
		return userId+userName+userPass;
	}
	

}
