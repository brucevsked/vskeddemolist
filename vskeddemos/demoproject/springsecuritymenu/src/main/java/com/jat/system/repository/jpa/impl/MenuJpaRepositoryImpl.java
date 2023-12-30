package com.jat.system.repository.jpa.impl;

import com.jat.system.model.Menu;
import com.jat.system.repository.MenuRepository;
import com.jat.system.repository.jpa.IMenuJpaRepository;
import com.jat.system.repository.jpa.po.MenuPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class MenuJpaRepositoryImpl implements MenuRepository {

    @Autowired
    IMenuJpaRepository iMenuJpaRepository;

    public Menu poToMenu(MenuPo po){
        if(po==null){
            return null;
        }
        Long id=po.getId();
        String name=po.getName();
        String url=po.getUrl();
        Menu parent=poToMenu(po.getParent());
        return new Menu(id,name,url,parent);
    }

    public MenuPo menuToPo(Menu menu){
        if(menu==null){
            return null;
        }
        MenuPo po=new MenuPo();
        po.setId(menu.getId());
        po.setName(menu.getName());
        po.setUrl(menu.getUrl());
        po.setParent(menuToPo(menu.getParent()));
        return po;
    }

    public List<Menu> posToMenus(List<MenuPo> pos){
        List<Menu> datas=new LinkedList<>();
        for(MenuPo po:pos){
            datas.add(poToMenu(po));
        }
        return datas;
    }

    public List<MenuPo> menusToPos(List<Menu> menus){
        List<MenuPo> datas=new LinkedList<>();
        for(Menu menu:menus){
            datas.add(menuToPo(menu));
        }
        return datas;
    }
}
