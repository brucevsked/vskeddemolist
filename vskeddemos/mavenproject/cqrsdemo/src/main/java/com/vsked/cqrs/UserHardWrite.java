package com.vsked.cqrs;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 复杂用法，读数据与写数据用不是同一份数据，可以理解为不同的表。读是一张表，写是一张表，而且读表与写表的表结构可能不相同
 * @author vsked
 *
 */
@Entity
@Table(name="userHardWrite")
public class UserHardWrite {
	
	@Id
	private Integer userId;
	private String userName;
	private String userPass;
	
	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public UserHardWrite(String userName) {
		super();
		this.userName = userName;
	}

	public UserHardWrite() {
		super();
	}

	public UserHardWrite(Integer userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public String toString() {
		return userId+userName+userPass;
	}
	
	

}
