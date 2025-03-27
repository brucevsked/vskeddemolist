package com.jat.service;

import com.jat.controller.model.RoleListRoleView;
import com.jat.repository.UserRoleRepository;
import com.jat.repository.model.UserRolePO;
import com.jat.system.model.role.Role;
import com.jat.system.model.user.User;
import com.jat.system.model.user.UserId;
import com.jat.system.model.userRole.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleService extends BaseService{
    private static final Logger log = LoggerFactory.getLogger(UserRoleService.class);

    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    RoleService roleService;

    public List<UserRolePO> findBy(UserId userId){
        return userRoleRepository.findByUserId(userId.getId());
    }

    public List<Integer> findRoleIdsBy(UserId userId){
        List<Integer> roleIds=new LinkedList<>();
        List<UserRolePO> userRoles=findBy(userId);
        for(UserRolePO userRole:userRoles){
            roleIds.add(userRole.getRole().getId());
        }
        log.debug("{}",roleIds);
        return roleIds;
    }

    public List<RoleListRoleView> findRoleByUserId(Map<String,Object> params){
        Integer idInt=getInt(params.get("id"));
        UserId userId=new UserId(idInt);
        List<RoleListRoleView> roles=new LinkedList<>();
        List<UserRolePO> userRoles=findBy(userId);
        for(UserRolePO userRole:userRoles){
            roles.add(new RoleListRoleView(userRole.getRole().getId()));
        }
        return roles;
    }

    public void updateIsDelByRoleId(Integer roleId){
        userRoleRepository.updateIsDelByRoleId(roleId);
    }


    public List<UserRole> add(User user,List<Integer> roleIds){
        List<UserRole> userRoles=new LinkedList<>();
        List<Role> roles=roleService.findRolesById(roleIds);

        for(Role role:roles){
            userRoles.add(new UserRole(user,role));
        }

        userRoles=add(userRoles);

        return userRoles;
    }

    public List<UserRole> add(List<UserRole> userRoles){
        List<UserRolePO> pos=new LinkedList<>();
        for(UserRole userRole:userRoles){
            pos.add(userRole.boToPo(0));
        }
        pos=userRoleRepository.saveAll(pos);
        userRoles=new LinkedList<>();
        for(UserRolePO po:pos){
            userRoles.add(UserRole.poToBo(po));
        }
        return userRoles;
    }

    public void save(List<UserRolePO> userRoles){
        userRoleRepository.saveAll(userRoles);
    }

    public void deleteByUserId(Integer userId){
        userRoleRepository.deleteByUserId(userId);
    }

}
