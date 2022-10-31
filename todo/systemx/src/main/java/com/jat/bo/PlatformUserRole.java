package com.jat.bo;

import java.util.Iterator;
import java.util.List;

public class PlatformUserRole {

    private PlatformUser platformUser;
    private List<Role> roles;

    public PlatformUserRole(PlatformUser platformUser, List<Role> roles) {
        if(platformUser ==null){
            throw new IllegalArgumentException("用户不能为空！");
        }
        if(roles ==null){
            throw new IllegalArgumentException("角色列表不能为空！");
        }
        this.platformUser = platformUser;
        this.roles = roles;
    }

    public void addRole(Role role){
        if(!isExist(role)){
            roles.add(role);
        }
    }

    public void remove(Role role){
        if(isExist(role)){
            Iterator<Role> roleIterator=roles.iterator();
            Role tmpRole=null;
            while (roleIterator.hasNext()){
                tmpRole=roleIterator.next();
                if(tmpRole.getId().getId()==role.getId().getId()){
                    roleIterator.remove();
                }
            }
        }
    }

    public boolean isExist(Role role){
        for(Role tmpRole:roles){
            if(role!=null && role.getId().getId()==tmpRole.getId().getId()){
                return true;
            }
        }
        return false;
    }


}
