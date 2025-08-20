package com.vsked.service;

import com.vsked.jpa.model.SysMenu;
import com.vsked.test.BaseTestWithTransactional;
import com.vsked.web.dto.MenuDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.List;

public class MenuServiceTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(MenuServiceTest.class);

    @Autowired
    MenuService menuService;

    @Test
    public void getMenuByUserName(){
        String username="admin";
        List<SysMenu> menus=menuService.getMenuByUserName(username);
        log.info("{}",menus);
    }

    @Test
    public void convertSysMenuToRouteTree(){
        String username="admin";
        List<SysMenu> menus=menuService.getMenuByUserName(username);
        log.info("{}",menus);
        List<MenuDTO> sysMenus=menuService.convertSysMenuToRouteTree(menus);
        log.info("{}",sysMenus);
    }



}
