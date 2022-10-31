package com.jat.bo;

public class Role {
    private RoleId id;
    private RoleName roleName;

    public RoleId getId() {
        return id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public Role(Long idPar, String roleNamePar) {
        RoleId id=new RoleId(idPar);
        RoleName roleName=new RoleName(roleNamePar);
        this.id = id;
        this.roleName = roleName;
    }
}
