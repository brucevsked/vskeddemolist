package com.jat.auth.infrastructure.persistence.jpa;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class RoleDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    private int id;
	
    private String name;
    
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<PermissionDto> permission;
	
	public Set<PermissionDto> getPermission() {
		return permission;
	}
	
	public void setPermission(Set<PermissionDto> permission) {
		this.permission = permission;
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
                ", \"permission\":\"" +permission +
                "\"}";
    }
    
    public String idToString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + 
                "\"}";
    }
    
	public RoleDto() {
		super();
	}
	
	public RoleDto(int id, String name, Set<PermissionDto> permission) {
		this.id = id;
		this.name = name;
		this.permission = permission;
	}

}
