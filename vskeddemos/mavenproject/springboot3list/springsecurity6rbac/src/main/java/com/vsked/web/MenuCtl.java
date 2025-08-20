package com.vsked.web;

import com.vsked.jpa.model.SysMenu;
import com.vsked.service.MenuService;
import com.vsked.tool.Response;
import com.vsked.web.dto.MenuDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuCtl {

    private static final Logger log = LoggerFactory.getLogger(MenuCtl.class);

    @Autowired
    MenuService menuService;

    @GetMapping("/currentLoginUserRoleMenu")
    public Response<List<MenuDTO>> currentRoleMenu(@AuthenticationPrincipal UserDetails principal) {
        String userName=principal.getUsername();
        List<SysMenu> menus=menuService.getMenuByUserName(userName);
        log.info("{}",menus);
        List<MenuDTO> sysMenus=menuService.convertSysMenuToRouteTree(menus);
        return new Response<>(200, "获取当前登录角色菜单成功", sysMenus);
    }


}
