package com.vsked.auth.infrastructure.persistence.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class PermissionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String operation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "{" + "\"id\":" + id + ", \"operation\":\"" + operation + "\"}";
	}

	public PermissionDto() {
		super();
	}

	public PermissionDto(int id, String operation) {
		this.id = id;
		this.operation = operation;
	}

}
