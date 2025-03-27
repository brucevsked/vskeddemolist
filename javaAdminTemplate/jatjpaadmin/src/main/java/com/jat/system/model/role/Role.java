package com.jat.system.model.role;

import com.jat.repository.model.RolePO;

public class Role {
    private RoleId id;
    private RoleName name;
    private RoleDescript descript;

    public Role(RoleId id, RoleName name, RoleDescript descript) {
        this.id = id;
        this.name = name;
        this.descript = descript;
    }

    public Role(RoleName name, RoleDescript descript) {
        this.name = name;
        this.descript = descript;
    }

    public RoleId getId() {
        return id;
    }

    public RoleName getName() {
        return name;
    }

    public RoleDescript getDescript() {
        return descript;
    }

    public static Role poToBo(RolePO po){
        if(po==null){
            throw new IllegalArgumentException("无角色信息！");
        }
        RoleId id=new RoleId(po.getId());
        RoleName name=new RoleName(po.getName());
        RoleDescript descript=new RoleDescript(po.getDescript());
        return new Role(id,name,descript);
    }

    public RolePO boToPo(Integer isDel){
        Integer id=null;
        if(this.getId()!=null){
            id=this.getId().getId();
        }
        return new RolePO(id, getName().getName(), getDescript().getDescript(),isDel );
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", descript=" + descript +
                '}';
    }
}
