package com.jat.system.model.roleResource;

import com.jat.system.model.resource.Resource;
import com.jat.system.model.role.Role;
import java.util.List;

public class RoleResource {
    private Role role;
    private List<Resource> resources;

    public RoleResource() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
