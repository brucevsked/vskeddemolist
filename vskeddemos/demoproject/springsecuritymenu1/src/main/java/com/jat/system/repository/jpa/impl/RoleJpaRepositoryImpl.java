package com.jat.system.repository.jpa.impl;

import com.jat.system.model.Menu;
import com.jat.system.model.Role;
import com.jat.system.repository.RoleRepository;
import com.jat.system.repository.jpa.po.MenuPo;
import com.jat.system.repository.jpa.po.RolePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class RoleJpaRepositoryImpl implements RoleRepository {
    @Autowired
    MenuJpaRepositoryImpl menuJpaRepositoryImpl;

    public Role poToRole(RolePo po){
        if(po==null){
            return null;
        }
        Long id=po.getId();
        String name=po.getName();
        List<Menu> menus=menuJpaRepositoryImpl.posToMenus(po.getMenus());
        return new Role(id,name,menus);
    }

    public RolePo roleToPo(Role role){
        if(role==null){
            return null;
        }
        RolePo po=new RolePo();
        po.setId(role.getId());
        po.setName(role.getName());
        List<MenuPo> menuPos=menuJpaRepositoryImpl.menusToPos(role.getMenus());
        po.setMenus(menuPos);
        return po;
    }

    public List<Role> posToRoles(List<RolePo> pos){
        List<Role> datas=new LinkedList<>();
        for(RolePo po:pos){
            datas.add(poToRole(po));
        }
        return datas;
    }

    public List<RolePo> rolesToPos(List<Role> roles){
        List<RolePo> datas=new LinkedList<>();
        for(Role role:roles){
            datas.add(roleToPo(role));
        }
        return datas;
    }
}
