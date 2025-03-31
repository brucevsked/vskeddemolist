package com.jat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jat.controller.model.MenuView;
import com.jat.controller.model.RoleAddEditResourceView;
import com.jat.service.ResourceService;
import com.jat.service.RoleResourceService;
import com.jat.util.JsonUtil;
import com.jat.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class RoleMenuController {
    private static final Logger log = LoggerFactory.getLogger(RoleMenuController.class);

    @Autowired
    RoleResourceService roleResourceService;

    @Autowired
    ResourceService resourceService;

    @GetMapping("/manager/role/roleMenu")
    public String roleMenu(HttpServletRequest req) throws JsonProcessingException {
        Response response = new Response();
        List<MenuView> menus=roleResourceService.findRoleMenus(req);
        String dataJson= JsonUtil.objectToJson(menus);
        response.setCode(0);
        response.setMsg("获取角色菜单成功");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

    @GetMapping("/manager/role/allMenus")
    public String allMenus() throws JsonProcessingException {
        Response response = new Response();
        List<MenuView> menus=resourceService.findAllMenus();
        String dataJson= JsonUtil.objectToJson(menus);
        response.setCode(0);
        response.setMsg("获取所有菜单成功");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }

    @GetMapping("/manager/role/getRoleResource")
    public String getRoleResource(@RequestParam Map<String,Object> params) throws JsonProcessingException {
        log.debug("{}",params);
        Response response = new Response();
        List<RoleAddEditResourceView> roleResourcesView=roleResourceService.findResourcesBy(params);
        String dataJson= JsonUtil.objectToJson(roleResourcesView);
        response.setCode(0);
        response.setMsg("获取角色菜单id成功");
        response.setData(dataJson);
        log.debug("{}",response);
        return response+"";
    }
}
