package com.vsked.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	private Integer rid;
	
	private String rolename;
	
	private String roledescription;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledescription() {
		return roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}

	public Role() {
		super();
	}

	public Role(Integer rid, String rolename, String roledescription) {
		super();
		this.rid = rid;
		this.rolename = rolename;
		this.roledescription = roledescription;
	}
	
	

}
