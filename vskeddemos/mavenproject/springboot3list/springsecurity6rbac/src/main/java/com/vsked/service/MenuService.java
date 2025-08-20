package com.vsked.service;

import com.vsked.jpa.model.SysMenu;
import com.vsked.jpa.repository.SysMenuRepository;
import com.vsked.web.dto.MenuDTO;
import com.vsked.web.dto.MenuMetaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private SysMenuRepository menuRepository;

    public List<SysMenu> getMenuByUserName(String userName) {
        return menuRepository.findMenusByUserName(userName);
    }

    public List<SysMenu> getAllActiveMenus() {
        return menuRepository.findByStatusOrderBySort((byte) 1);
    }


    /**
     * 将SysMenu列表转换为前端路由结构
     * @param sysMenus 数据库中的菜单列表
     * @return 转换后的菜单树结构
     */
    public List<MenuDTO> convertSysMenuToRouteTree(List<SysMenu> sysMenus) {
        if (sysMenus == null || sysMenus.isEmpty()) {
            return new ArrayList<>();
        }

        // 过滤掉已删除的菜单
        List<SysMenu> validMenus = sysMenus.stream()
                .filter(menu -> menu.getIsdeleted() == null || menu.getIsdeleted() == 0)
                .filter(menu -> menu.getStatus() == null || menu.getStatus() == 1)
                .collect(Collectors.toList());

        // 构建菜单树
        return buildMenuTree(validMenus, 0L);
    }

    /**
     * 递归构建菜单树
     * @param menus 菜单列表
     * @param parentId 父级ID
     * @return 菜单树结构
     */
    private List<MenuDTO> buildMenuTree(List<SysMenu> menus, Long parentId) {
        List<MenuDTO> result = new ArrayList<>();

        // 筛选出当前级别的菜单
        List<SysMenu> currentLevelMenus = menus.stream()
                .filter(menu -> (menu.getParentid() == null && parentId == 0) ||
                        (menu.getParentid() != null && menu.getParentid().equals(parentId)))
                .sorted(Comparator.comparing(SysMenu::getSort, Comparator.nullsFirst(Integer::compareTo)))
                .toList();

        for (SysMenu sysMenu : currentLevelMenus) {
            MenuDTO menuDTO = convertSysMenuToMenuDTO(sysMenu);

            // 递归处理子菜单
            List<MenuDTO> children = buildMenuTree(menus, sysMenu.getId());
            if (!children.isEmpty()) {
                menuDTO.setChildren(children);
            }

            result.add(menuDTO);
        }

        return result;
    }

    /**
     * 将单个SysMenu转换为MenuDTO
     * @param sysMenu 数据库菜单实体
     * @return 菜单DTO
     */
    private MenuDTO convertSysMenuToMenuDTO(SysMenu sysMenu) {
        MenuDTO menuDTO = new MenuDTO();

        // 基本属性映射
        menuDTO.setPath(sysMenu.getPath());
        menuDTO.setComponent(sysMenu.getComponent());
        menuDTO.setName(sysMenu.getName());
        menuDTO.setRedirect(sysMenu.getRedirect());

        MenuMetaDTO meta = new MenuMetaDTO();
        meta.setTitle(sysMenu.getTitlekey() != null ? sysMenu.getTitlekey() : sysMenu.getTitle());
        meta.setIcon(sysMenu.getIcon());

        // 处理布尔值属性
        if (sysMenu.getAlwaysshow() != null) {
            meta.setAlwaysShow(sysMenu.getAlwaysshow() == 1);
        }

        if (sysMenu.getNocache() != null) {
            meta.setNoCache(sysMenu.getNocache() == 1);
        }

        if (sysMenu.getAffix() != null) {
            meta.setAffix(sysMenu.getAffix() == 1);
        }

        menuDTO.setMeta(meta);

        // 特殊处理component值
        if ("#".equals(sysMenu.getComponent())) {
            menuDTO.setComponent("#");
        } else if ("##".equals(sysMenu.getComponent())) {
            menuDTO.setComponent("##");
        }

        return menuDTO;
    }
}
