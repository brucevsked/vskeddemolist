package com.jat.system.model.userRole;

import com.jat.repository.model.RolePO;
import com.jat.repository.model.UserPO;
import com.jat.repository.model.UserRolePO;
import com.jat.system.model.role.Role;
import com.jat.system.model.user.User;


public class UserRole {
    private User user;
    private Role role;

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }

    public static UserRole poToBo(UserRolePO po){
        if(po==null){
            throw new IllegalArgumentException("无用户角色信息！");
        }
        User user=User.poToBo(po.getUser());
        Role role= Role.poToBo(po.getRole());
        return new UserRole(user,role);
    }

    public UserRolePO boToPo(Integer isDel){
        User user=getUser();
        UserPO userPO=user.boToPo(isDel);
        Role role=getRole();
        RolePO rolePO=role.boToPo(isDel);
        return new UserRolePO(userPO,rolePO);
    }

    @Override
    public String toString() {
        return "{" +
                "user=" + user +
                ", role=" + role +
                '}';
    }
}
