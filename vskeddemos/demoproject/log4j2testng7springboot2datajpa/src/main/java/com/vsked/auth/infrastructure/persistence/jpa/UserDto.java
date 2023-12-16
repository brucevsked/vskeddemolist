package com.vsked.auth.infrastructure.persistence.jpa;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    private int id;

    private String name;
    
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<RoleDto> roles;
    
	public Set<RoleDto> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name +
                ", \"roles\":\"" + roles +
                "\"}";
    }
    
    public String idToString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name +
                "\"}";
    }
    
	public UserDto() {
		super();
	}
	
	public UserDto(int id, String name, Set<RoleDto> roles) {
		this.id = id;
		this.name = name;
		this.roles = roles;
	}

}
