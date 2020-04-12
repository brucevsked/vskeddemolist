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
@Table(name="userHardRead")
public class UserHardRead {
	
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

	public UserHardRead(String userName) {
		super();
		this.userName = userName;
	}

	public UserHardRead() {
		super();
	}

	public UserHardRead(Integer userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public String toString() {
		return userId+userName+userPass;
	}
	
	

}
