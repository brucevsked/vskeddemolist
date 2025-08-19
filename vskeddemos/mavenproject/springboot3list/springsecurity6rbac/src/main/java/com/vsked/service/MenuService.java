package com.vsked.service;

import com.vsked.jpa.model.SysMenu;
import com.vsked.jpa.repository.SysMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private SysMenuRepository menuRepository;

    public List<SysMenu> getMenuByUserId(Long userId) {
        return menuRepository.findMenusByUserId(userId);
    }

    public List<SysMenu> getAllActiveMenus() {
        return menuRepository.findByStatusOrderBySort((byte) 1);
    }
}
